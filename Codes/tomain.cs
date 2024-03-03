using System.Collections;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.SceneManagement;

public class tomain : MonoBehaviour
{
    private string token;

    void Start()
    {
        StartCoroutine(AuthenticateAndFetchProfile());
    }

    IEnumerator AuthenticateAndFetchProfile()
    {
        string apiKey = "NjVjNjA0MGY0Njc3MGQ1YzY2MTcyMmNjOjY1YzYwNDBmNDY3NzBkNWM2NjE3MjJjMg";
        string endPoint = "http://20.15.114.131:8080/api/login";

        using (UnityWebRequest www = UnityWebRequest.Post(endPoint, new WWWForm()))
        {
            www.SetRequestHeader("Content-Type", "application/json");
            byte[] bodyRaw = System.Text.Encoding.UTF8.GetBytes("{\"apiKey\": \"" + apiKey + "\"}");
            www.uploadHandler = new UploadHandlerRaw(bodyRaw);
            www.downloadHandler = new DownloadHandlerBuffer();

            yield return www.SendWebRequest();

            if (www.result == UnityWebRequest.Result.Success)
            {
                string jsonResponse = www.downloadHandler.text;
                TokenResponse response = JsonUtility.FromJson<TokenResponse>(jsonResponse);
                token = response.token;
                Debug.Log("Token fetched: " + token);
                yield return StartCoroutine(FetchPlayerProfile());
            }
            else
            {
                Debug.LogError("Failed to fetch token: " + www.error);
            }
        }
    }

    IEnumerator FetchPlayerProfile()
    {
        if (string.IsNullOrEmpty(token))
        {
            Debug.LogError("Token not found.");
            yield break;
        }

        string url = "http://20.15.114.131:8080/api/user/profile/view";

        using (UnityWebRequest www = UnityWebRequest.Get(url))
        {
            www.SetRequestHeader("Authorization", "Bearer " + token);

            yield return www.SendWebRequest();

            if (www.result == UnityWebRequest.Result.Success)
            {
                string responseBody = www.downloadHandler.text;
                Debug.Log("Player profile response: " + responseBody);

                SceneManager.LoadScene("Main Menu");
            }
            else
            {
                Debug.LogError("Failed to fetch player profile: " + www.error);
            }
        }
    }

    private class TokenResponse
    {
        public string token;
    }
}