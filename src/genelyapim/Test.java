/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
* @file Test.java
* @description testlerin yapildigi dosya.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class Test {

    public static void main(String[] args) {

        
       
        KelimeSikligiAgaci<String> klm = new KelimeSikligiAgaci<>();
        klm.printInOrder();
        
        klm.Query("data");
        
        
    }
    
    
}
