// Main method to demonstrate binary tree
// and binary tree node
//
// David John
// November, 2020


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create empty myTree
        BinaryTree<String> myTree = new BinaryTree<String>();
        Scanner keyboard = new Scanner(System.in);

        // create a number of random integers and insert them into myTree
        for (int i=0; i< 5; i++){

            // generate random number in range [-15, 50] in Java
            System.out.print("Enter item #"+i+": ");
            String randValue = keyboard.next();

            // insert each into myTree
            myTree.insert(randValue);
        }

        //System.out.println(myTree);
        System.out.print("The nodes of tree are (inorder): ");
        System.out.println(myTree.inorder());
        // System.out.print("The breadth order of the tree is: ");
        // System.out.println(myTree);
    }
}
