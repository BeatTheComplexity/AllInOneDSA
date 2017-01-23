package allinonedsa;

import tree.BoundaryTraversal;
import tree.node.BinaryTreeNode;

public class AllInOneDSA {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(12);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);
        root.right = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(25);
        
        BoundaryTraversal.printBoundary(root);
    }
}
