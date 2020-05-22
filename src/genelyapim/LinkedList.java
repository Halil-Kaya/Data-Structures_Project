/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file LinkedList.java
* @description istenilen BTS agaç yapısının içerisinde bulunan Linkedlist yapisi.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class LinkedList<T> {
    
    public LinkedListNode<T> head;
    public int size = 0;
    
    public void addLast(LinkedListNode<T> newNode) {
    
        if (isEmpty()) {
            head = newNode;
        } else {
            LinkedListNode<T> tmp = head;
            while (tmp.nextLinkedListNode != null) {
                if (newNode.fileName.equals(tmp.fileName)) {
                    tmp.adet = tmp.adet + newNode.adet;//eğer eklenecek olan dosya adı zaten varsa var olan node adetini arttırıyor
                    return;//guncelleme yapti ve islem bittigi icin fonksiyonu bitiriyor
                }
                tmp = tmp.nextLinkedListNode;
            }
            if (newNode.fileName.equals(tmp.fileName)) {//en son node geldiginde tekrar bi kontrol yapıyor
                tmp.adet = tmp.adet + newNode.adet;//eğer eklenecek dosya adı zaten varsa var olan node adetini arttırıyor
                return;//guncelleme yapti ve islem bittigi icin fonksiyonu bitiriyor
            }
            tmp.nextLinkedListNode = newNode;
        }
        //eger fonksiyondan cikilmamisa ekleme yapilmis demektir bu yüzden size i +1 arttırıyorum
        size++;
    }
    
    public void addLast(T data) {
        
        addLast(new LinkedListNode<>(data));
        
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    //ekrana bastiriyorum
    public void print() {
        LinkedListNode<T> tmp = head;
        while (tmp != null) {
            System.out.print("[" + tmp.fileName + "][" + tmp.adet + "] -> ");
            tmp = tmp.nextLinkedListNode;
        }
        
    }
}
