using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;

public class ClickButtons : MonoBehaviour, IPointerEnterHandler, IPointerExitHandler
{
    public Sprite defaultImage; 
    public Sprite hoverImage; 
    public Sprite clickedImage; 

    private Button button;
    private Image buttonImage;

    void Start()
    {
        button = GetComponent<Button>();
        buttonImage = GetComponent<Image>();

        buttonImage.sprite = defaultImage;
        button.onClick.AddListener(ChangeImageOnClick);
    }

    void ChangeImageOnClick()
    {
        buttonImage.sprite = clickedImage;
    }

    public void OnPointerEnter(PointerEventData eventData)
    {
        buttonImage.sprite = hoverImage;
    }

    public void OnPointerExit(PointerEventData eventData)
    {
        buttonImage.sprite = defaultImage;
    }
}
