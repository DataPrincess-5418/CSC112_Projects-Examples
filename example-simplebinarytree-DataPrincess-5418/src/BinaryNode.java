// Simple BinaryNode using a generic that
// extends Comparable (.compareTo())
//
// David John
// November 2020
// April 2021

public class BinaryNode<E extends Comparable> {

    // each node contains three objects:  the data, and references to the
    //      left and right children
    private E  Data;
    private BinaryNode<E> leftchild;
    private BinaryNode<E> rightchild;


    // alternate constructor that creates
    // a new leaf in the binary tree
    public BinaryNode(E item){
        Data = item;
        leftchild = null;
        rightchild = null;
    }

    // getters
    public E getData(){
        return Data;
    }
    public BinaryNode<E> getLeft(){
        return leftchild;
    }
    public BinaryNode<E> getRight(){
        return rightchild;
    }


    //  recursively insert item as a new leaf
    public void insert(E item){
        int compareV = item.compareTo(this.Data);

        // already in tree
        if (compareV ==0) {
            return;                // ignore it
        }
        // insert into the left subtree
        else if (compareV < 0){

            // if leftsubtree is empty, insert item here
            if (leftchild == null){
                leftchild = new BinaryNode<E>(item);
                return;
            }
            // else insert item into non-empty leftsubtree
            else {
                leftchild.insert(item);
                return;
            }

        }
        // insert into the right subtree
        else {

            // if rightsubtree is empty, insert item here
            if (rightchild == null){
                rightchild = new BinaryNode<E>(item);
                return;
            }
            // else insert item into non-empty rightsubtree
            else {
                rightchild.insert(item);
                return;
            }
        }
    }

    // recursive look for a match to "item"
    public E find(E item){


        int compareV = item.compareTo(this.Data);

        // item equals Data
        if (compareV ==0){
            return Data;
        }
        // item preceeds Data
        else if (compareV <0){
            if (isLeftChildEmpty()) return null;  // nothing to the left
            return leftchild.find(item);         // search on the left
        }
        // item follows Data
        else {
            if (isRightChildEmpty()) return null;  // nothing to the right
            return rightchild.find(item);         // search on the right
        }
    }

    // boolean to determine if Left/Right child is empty
    public boolean isLeftChildEmpty(){
        return leftchild == null;
    }
    public boolean isRightChildEmpty(){
        return rightchild == null;
    }



    // recursive inorder traversal of the nodes
    public String inorder(){
        String Result = " ";

        // if there is a nonempty left child go there first
        if (!isLeftChildEmpty()){
            Result = Result + leftchild.inorder();
        }

        // now print value at the node
        Result = Result + " " + Data;

        // if there is a nonempty right child go there last
        if (!isRightChildEmpty()){
            Result = Result + " " + rightchild.inorder();
        }

        return Result;
    }

    public String toString(){
        return "<"+Data+","+leftchild+","+rightchild+">";
    }


}
