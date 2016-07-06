package tree;

import java.util.Stack;
import tree.node.BinaryTreeNode;

public class InOrderTraversal {

    public static void inOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderRecursive(root.right);
        }
    }

    public static void inOrderNonRecursive(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode current = root;
        boolean isDone = false;

        while (!isDone) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else if (stack.isEmpty()) {
                isDone = true;
            } else {
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }
}
