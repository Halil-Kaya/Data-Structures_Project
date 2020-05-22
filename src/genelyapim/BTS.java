/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genelyapim;

/**
* @file BTS.java
* @description istenilen BTS ağaç yapısının oluşturulduğu dosya.
* @assignment Veri Yapıları 2.Proje
* @date 11/05/2020
* @author Halil İbrahim Kaya halilibrahim.kaya@stu.fsm.edu.tr
*/
public class BTS<T extends Comparable<T>> {

    private BTSNode<T> root;
    
    
    //BTS yapisina gore kelimeyi ekliyor eger kelime zaten varsada gonderilen fileName bilgisine gorede
    //kelime hangi dosyada gecmisse onun adetini +1 arttiriyor
    public void insertRecursive(T newkelime, String fileName) {
        
        root = insertRecursive(root, newkelime, fileName);
         
        //root yapisi icin ayriyetten bir kontrol yapiliyor
        //eker rootun kelimesi gelen kelimeyle ayniysa linkedlistine ekleniyor
        if(root.kelime.equals(newkelime)){
            root.linkedList.addLast((T)fileName);
        }
        
    }

    private BTSNode<T> insertRecursive(BTSNode<T> node, T newkelime, String fileName) {

        if (node == null) {
            return new BTSNode<T>(newkelime);
        } else {

            if (newkelime.compareTo(node.kelime) > 0) {
                //saga dogru gidiyor
                node.rightChild = insertRecursive(node.rightChild, newkelime, fileName);
                //en saga geldiginde eger kelime uyusuyorsa linkedlistine dosya adını ekliyor
                if(node.rightChild.kelime.equals(newkelime)){
                    //linkedlistin icinde de aynı dosya isminden varsa adetini guncelliyecek
                    node.rightChild.linkedList.addLast((T) fileName);
                }
                
            } else if (newkelime.compareTo(node.kelime) < 0) {
                
                //sola dogru gidiyor
                node.leftChild = insertRecursive(node.leftChild, newkelime, fileName);
                //en sola geldiginde eger kelime uyusuyorsa linkedlistine dosya adını ekliyor
                if(node.leftChild.kelime.equals(newkelime)){
                    //linkedlistin icinde de aynı dosya isminden varsa adetini guncelliyecek
                    node.leftChild.linkedList.addLast((T) fileName);
                }
                
            } 

            return node;
        }
    }
    
    
    
   
    //Aranan node u kelimesi sayesinde buluyor ve linkedlistinin headini donuyor
    public LinkedListNode search(T searchData) {

        if (isEmpty()) {
            System.out.println("eleman yok");
        } else {

            BTSNode<T> tmp = root;
            while (tmp != null) {
                //saga giderek ariyor
                if (searchData.compareTo(tmp.kelime) > 0) {

                    tmp = tmp.rightChild;

                }//sola giderek ariyor
                else if (searchData.compareTo(tmp.kelime) < 0) {

                    tmp = tmp.leftChild;

                }//bulduysa buraya girecek
                else if(searchData.compareTo(tmp.kelime) == 0) {
                    //nodun sahip oldugu linkedlistin headini donduruyor
                    return tmp.linkedList.head;
                }

            }

        }

        return null;

    }

    public void preorder() {
        System.out.println("preorder: ");
        preorder(root);
        System.out.println("");
    }

    private void preorder(BTSNode<T> node) {

        if (node != null) {
            System.out.print(node.kelime + "(");
            node.linkedList.print();
            System.out.print(")");;
            preorder(node.leftChild);
            preorder(node.rightChild);
        }

    }

    public void inorder() {
        System.out.println("ineorder: ");
        ineorder(root);
        System.out.println("");
    }

    private void ineorder(BTSNode<T> node) {

        if (node != null) {
            ineorder(node.leftChild);
            System.out.print(" " + node.kelime + "(");
            node.linkedList.print();
            System.out.print(") ");
            ineorder(node.rightChild);
        }

    }

    public void postorder() {
        System.out.println("postorder: ");
        postorder(root);
        System.out.println("");
    }

    private void postorder(BTSNode<T> node) {

        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.kelime + "(");
            node.linkedList.print();
            System.out.print(")");
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

}
