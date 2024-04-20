package org.example;

import java.util.Optional;
import java.util.Random;

class listnode {
    int valor;
    listnode next;

    listnode(int valor){
        this.valor = valor;
        this.next = null;

    }
}
class linkedList {
    listnode head;

    linkedList (){
        this.head = null;
    }
    void add(int valor){
        listnode newNode = new listnode(valor);
        if(head == null){
            head = newNode;
        }
        else {
            listnode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

    }

    boolean buscar(int val) {
        listnode current = head;
        while (current != null) {
            if (current.valor == val) {
                return true;

            }
            current = current.next;
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BSTree {
    TreeNode root;

    BSTree() {
        this.root = null;
    }
    void add(int val) {
        root = insertRecursive(root, val);
    }


    private TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }

    boolean buscar(int val) {
        return buscarR(root, val);
    }
    public boolean buscarR(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        if (val < root.val) {
            return buscarR(root.left, val);
        }
        return buscarR(root.right, val);
    }



}



public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        linkedList lista = new linkedList();
        BSTree bst = new BSTree();





        long LLtime = 0;
        long bstTotalTime = 0;



        int min = 10000;
        int max = 15000;


        int cvalue = random.nextInt(max - min + 1) + min;


        for (int i = 0; i < cvalue; i++) {
            int val = random.nextInt(cvalue);
            lista.add(val);
            bst.add(val);
        }


        int searchVal = random.nextInt(10000);
        System.out.println("Valor a buscar:" + searchVal);

        long startTime = System.nanoTime();
        lista.buscar(searchVal);
        long endTime = System.nanoTime();
        LLtime += endTime - startTime;



        long startTimeB = System.nanoTime();
        bst.buscar(searchVal);
        long endTimeB = System.nanoTime();
        bstTotalTime += endTimeB - startTimeB;





        System.out.println("La lista tarda " + LLtime + "ns");
        System.out.println("El BST tarda " + bstTotalTime + "ns");
    }
}
