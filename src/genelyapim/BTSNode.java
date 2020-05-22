/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file BTSNode.java
* @description istenilen BTS ağaç yapısının Node yapısı.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class BTSNode<T extends Comparable<T>> {

    T kelime;
    BTSNode<T> leftChild;
    BTSNode<T> rightChild;
    //Her dugumun kendine ait bir linkedlist yapisi var
    LinkedList<T> linkedList = new LinkedList<>();

    public BTSNode(T kelime) {
        this.kelime = kelime;
    }

   
}
