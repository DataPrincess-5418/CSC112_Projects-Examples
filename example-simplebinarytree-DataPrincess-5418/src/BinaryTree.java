//  Simple BinaryTree example using a generic E that
//  extends Comparable (.compareTo())
//
//  David John
//  November 2020
//  April 2021

import java.util.LinkedList;
import java.util.Queue;

// sorted list i need compareTo() in the class E
public class BinaryTree<E extends Comparable> {

    private BinaryNode<E> root;   // root of tree

    // default constructor
    public BinaryTree(){
        root = null;
    }

    // insert item into binary tree
    public void insert(E item) {

        // if the tree is empty, then create a binary node
        // as the root with item in it
        if (root == null) {
            root = new BinaryNode<E>(item);
            return;
        }

        // insert item as a node using the order relation
        root.insert(item);
    }

    // find item in binary tree
    public E find(E item){

        // if tree is empty, item not found
        if (root == null){
            return null;
        }

        // find the "item" by starting at the root
        return root.find(item);

    }

    // print tree in inorder
    public String inorder(){
        String Result = "";

        // if tree is empty, done
        if (root == null){
            return Result;
        }

        // call recursive BinaryNode inorder() starting with the root
        return root.inorder();
    }

    // print tree in a breadth first order
    public String toString(){

        Queue<BinaryNode<E>> myQueue = new LinkedList<BinaryNode<E>>();
        String Result = "";

        if (root == null) return Result;

        myQueue.add(root);
        while (!myQueue.isEmpty()){
            BinaryNode<E> current = myQueue.remove();
            Result = Result + " " + current.getData();
            if (!current.isLeftChildEmpty()){
                myQueue.add(current.getLeft());
            }
            if (!current.isRightChildEmpty()){
                myQueue.add(current.getRight());
            }
        }

        return Result;
    }
}
