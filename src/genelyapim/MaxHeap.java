/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file MaxHeap.java
* @description  query sorgudan sonra olusacak olan Heap yapisinin dosyası.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class MaxHeap<T extends Comparable>  {
    
    private HeapData[] heap;
    private int size;

    public MaxHeap(int capacity) {
        this.heap = new HeapData[capacity];
        this.size = 0;
    }
    
    
    //parentin indexini buluyor
    private int parent(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    //yer degistirme islemini yapiyor
    private void swap(int parentIndex, int childIndex) {
        HeapData temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
    }

    public void insert(T fileName,int adet) {
        if (size < heap.length) {
            
            //yeni bir nesne olusturuyorum
            heap[size] = new HeapData(fileName.toString(), adet);
            
            int current = size++;
            
            //heap yapisina gore ekleme yapiyorum
            while (heap[current].adet > heap[parent(current)].adet) {

                swap(parent(current), current);
                current = parent(current);
            }

        } else {
            System.out.println("heap is full !");
        }

    }

   

    

   
    //ekrana bastiriyorum 
    public void printArray() {
        
        //buyukten kucuge siraliyorum
        for (int i = 0; i < heap.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < heap.length; j++) {
                if (heap[maxIndex].adet < heap[j].adet) {
                    maxIndex = j;
                }
            }
            // swap
            if (i != maxIndex) {
                HeapData temp = heap[i];
                heap[i] = heap[maxIndex];
                heap[maxIndex] = temp;
            }
        }
        
        
        //ekrana basiyorum
        for (HeapData element : heap) {
            System.out.print(element.fileName + "("+element.adet+"), ");
        }
        System.out.println("");
        
        
    }

  
   

    
}
