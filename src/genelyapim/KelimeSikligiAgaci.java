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
* @file KelimeSikligiAgaci.java
* @description Dosya secme ve istenilen agac yapisinin olusturulmasini saglayan dosya.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class KelimeSikligiAgaci<T extends Comparable<T>> {

    private BTS<T> bts;

    
    public KelimeSikligiAgaci() {
        bts = new BTS<T>();
        
        //dosyalari kullanicaya seçtirip diziye atiyorum
        File[] dosyalar = dosyalariAl();
            
        //dosyalari fonksiyonuma gonderiyorum ve orda olusturuyorum
        agaciOlustur(dosyalar);

    }

    
    public File[] dosyalariAl() {
        
        //dosya yolus sectiriyorum
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("/home/minter"));
        fc.setDialogTitle("pencere");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

        }
        //dosya yolunu duyuyorum
        String dosyaYolu = fc.getSelectedFile().getAbsolutePath();
         
        File dir = new File(dosyaYolu);
        
        //o dosya yolundaki dosyalari aliyorum
        File[] matches = dir.listFiles();
            
        //dosyalari donduruyorum
        return matches;
    }

    
    public void agaciOlustur(File[] dosyalar) {
        //dosyalardaki kelimeleri agacıma ekliyorum
        String word = "";
        FileInputStream fis = null;
        try {
            
            //dosyalari teker teker geziyor
            for (File file : dosyalar) {

                fis = new FileInputStream(file);
                int deger;
                char harf;
                //kelime kelime eklemesi icin bir algoritma olusturdum bu algoritmada
                //bi harftan baslayip bosluk gelene kadar 'word' e ekliyor
                while ((deger = fis.read()) != -1) {
                    
                    harf = (char) deger;
                    //gelen sey bir harf veya sayi ise word' e ekliyorum
                    if (Character.isLetterOrDigit(harf)) {
                        word += harf;

                    } else {
                        //bosluk geldiyse word'u kontrol ediyorum ici bos mu diye
                        if (!word.isEmpty()) {
                           //bos degilse agacıma ekliyorum yanında da dosya adini gonderiyorum
                            bts.insertRecursive((T) word.toLowerCase(), file.getName());
                            word = "";//word u sifirirliyorum be islem tekrar ediyor

                        }

                    }

                }
            }

        } catch (Exception e) {
            System.out.println("hata");
        } finally {

            try {
                fis.close();
            } catch (Exception e) {
                System.out.println("hata");
            }

        }
    }

    public void Query(String query) {
        //sorguyu oncelikle kucuk harfe donusturuyorum
        query = query.toLowerCase();
        //bosluklara gore bolup diziye atiyorum
        String[] arananKelimeler = query.split(" ");
        
        /*
            Alaka Duzeylerini bir yapida toplamam gerek şöyle anlatayım
            
            'data' kelimesi 
        
            a.html'de -> 4
            b.html'de -> 3 
            
            kez geciyor
        
            'structures' kelimesi
        
            a.html'de -> 1
        
            kez geciyor
        
            eger kullanici 'data structures' kelimesini girerse
        
            a.html -> 5
            b.html -> 3
            
            kez geciyor demesi gerekiyor istenen bu
        
            bu nedenden bir linkedlist olusturdum aranan kelimelerin node ın içindeki linkedlistlerini kendine ekleyerek
            alakaDuzeylerine ait tek bir linkedlist olusuyor
        
        
        */
        //hepsini tek bir yerde tutacak linkedlist yapim
        LinkedList<T> alakaDuzeyleri = new LinkedList<>();
        
        //arananKelimeleri teker teker geziyorum
        for (String kelime : arananKelimeler) {
             
            //agacimin icerisinden aranan kelimenin node ndaki linkedlist yapisinin headini tmp ye eşitliyorum
            LinkedListNode<T> tmp = bts.search((T) kelime);
            
            //yapiyi geziyorum
            while (tmp != null) {
                //o node i kopyalayip hepsini tek bir yerde toplayacagim linkedliste ekliyorum
                LinkedListNode<T> newNode = new LinkedListNode<>(tmp.fileName, tmp.adet);
                alakaDuzeyleri.addLast(newNode);
                tmp = tmp.nextLinkedListNode;
            }

        }
        
        
        //hepsini tek bir yapida topladim artik olusturudugum yapiyi gezmenin vakti geldi
        LinkedListNode<T> tmpOfAlakaDuzeyi = alakaDuzeyleri.head;
        
        //maxHeap nesnesi olusturuyorum  hepsini tek bir yapida topladigim alakaDuzeyleri linkedlistimdeki her bir elemani
        //maxHeap yapisina ekliyecem maxHeap yapisi da kendi icerisinde bunlari buyukten kucuge dogru kendi icinde siralayarak
        //ekliyecek
        MaxHeap maxHeap = new MaxHeap(alakaDuzeyleri.size);

        
        while (tmpOfAlakaDuzeyi != null) {
            //dosya ismini ve adetini vererek ekliyorum
            maxHeap.insert( tmpOfAlakaDuzeyi.fileName , tmpOfAlakaDuzeyi.adet );
            tmpOfAlakaDuzeyi = tmpOfAlakaDuzeyi.nextLinkedListNode;
        }
        //en sonunda da ekrana bastiriyorum
        maxHeap.printArray();

    }

    public void printInOrder() {
        bts.inorder();
    }

    public void printPostOrder() {
        bts.postorder();
    }

    public void printPreOrder() {
        bts.preorder();
    }

}
