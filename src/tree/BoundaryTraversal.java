package tree;

import tree.node.BinaryTreeNode;

public class BoundaryTraversal {

    // A function to do boundary traversal of a given binary tree
    public static void printBoundary(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.data);

            // Print the left boundary in top-down manner.
            printBoundryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundryRight(node.right);
        }
    }

    // A simple function to print leaf nodes of a binary tree
    private static void printLeaves(BinaryTreeNode node) {
        if (node != null) {
            printLeaves(node.left);
            if (node.left == null && node.right == null) {
                System.out.println(node.data);
            }
            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    private static void printBoundryLeft(BinaryTreeNode node) {
        if (node != null) {
            if (node.left != null) {
                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.println(node.data);
                printBoundryLeft(node.left);
            } else if (node.right != null) {
                System.out.println(node.data);
                printBoundryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    private static void printBoundryRight(BinaryTreeNode node) {
        if (node != null) {
            if (node.right != null) {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundryRight(node.right);
                System.out.println(node.data);
            } else if (node.left != null) {
                printBoundryRight(node.left);
                System.out.println(node.data);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    /*
    To run this 
    paste this in void main
    
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(12);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);
        root.right = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(25);
        
        BoundaryTraversal.printBoundary(root);
     */
}
