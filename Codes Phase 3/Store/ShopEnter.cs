using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ShopEnter : MonoBehaviour
{
    public GameObject ShopPanel;


    public void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Player"))
        {
            ShopPanel.SetActive(true);
        }
    }


}
