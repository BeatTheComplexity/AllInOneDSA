package tree;

import java.util.Stack;
import tree.node.BinaryTreeNode;

public class PreOrderTraversal {

    public static void preOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public static void preOrderNonRecursive(BinaryTreeNode root) {
        //ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            //return res;
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            BinaryTreeNode current = stack.pop();
            //res.add(current.data);
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        //return res;
    }
}
