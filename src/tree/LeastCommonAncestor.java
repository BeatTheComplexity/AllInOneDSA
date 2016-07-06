package tree;

import tree.node.BinaryTreeNode;

public class LeastCommonAncestor {

    /*
        Let T be a rooted tree. 
        The lowest common ancestor between two nodes n1 and n2 
        is defined as the lowest node in T 
        that has both n1 and n2 as descendants 
        (where we allow a node to be a descendant of itself).

        The LCA of n1 and n2 in T is 
        the shared ancestor of n1 and n2 
        that is located farthest from the root. 
        Computation of lowest common ancestors 
        may be useful, for instance, as part of a procedure 
        for determining the distance between 
        pairs of nodes in a tree: the distance from n1 to n2 
        can be computed as the distance from the root to n1, 
        plus the distance from the root to n2, 
        minus twice the distance from the root to their lowest common ancestor.
     */

    public static BinaryTreeNode getLeastCommonAncestor(BinaryTreeNode root,
            int num1, int num2) {

        if (root == null) {
            return null;
        }

        if (root.data == num1 || root.data == num2) {
            return root;
        }

        BinaryTreeNode leftNode = getLeastCommonAncestor(root.left, num1, num2);
        BinaryTreeNode rightNode = getLeastCommonAncestor(root.right, num1, num2);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode != null ? leftNode : rightNode;
    }

}
