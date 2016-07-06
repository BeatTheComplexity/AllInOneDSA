package tree;

import java.util.Stack;
import tree.node.BinaryTreeNode;

public class PostOrderTraversal {

    public static void postOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void postOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        BinaryTreeNode prev = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                System.out.print(current.data + " ");
                stack.pop();
            }

            prev = current;
        }
    }

}
