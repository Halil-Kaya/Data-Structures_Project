/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file LinkedListNode.java
* @description istenilen BTS agaç yapısının içerisinde bulunan Linkedlist yapisinin Node yapisi.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class LinkedListNode<T> {
    //yapim dosya ismi ve adetini Tutuyor
    public T fileName;
    public int adet = 1;
    public LinkedListNode<T> nextLinkedListNode;
    
    public LinkedListNode(T fileName){
        this.fileName = fileName;
    }
    public LinkedListNode(T fileName,int adet){
        this.fileName = fileName;
        this.adet = adet;
    }

}
