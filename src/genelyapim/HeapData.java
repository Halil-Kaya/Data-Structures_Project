/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file HeapData.java
* @description istenilen Heap yapısının içindeki dizinin Node yapısı.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/

public class HeapData<T extends Comparable<T>> {
    
    public String fileName = "";
    public int adet = 0;
    
    //Heap imin dizisi HeapData dan olusuyor dosya adını ve adetini sakliyor
    public HeapData(String fileName,int adet){
        this.fileName = fileName;
        this.adet = adet;
    }
    
    
}
