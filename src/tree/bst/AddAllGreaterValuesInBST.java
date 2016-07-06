package tree.bst;

import tree.node.BinaryTreeNode;

public class AddAllGreaterValuesInBST {

    /*
        Add all greater values to every node in a given BST
    
        We can do it using a single traversal. 
        The idea is to use following BST property. 
        If we do reverse Inorder traversal of BST, 
        we get all nodes in decreasing order. 
        We do reverse Inorder traversal and keep track 
        of the sum of all nodes visited so far, 
        we add this sum to every node.
     */
    public static int sum = 0;

    public static void addAllGreaterValues(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        addAllGreaterValues(root.right);
        sum = sum + root.data;
        root.data = sum;
        addAllGreaterValues(root.left);
    }
}
