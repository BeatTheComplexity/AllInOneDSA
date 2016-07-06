package tree;

import java.util.LinkedList;
import java.util.Queue;
import tree.node.BinaryTreeNode;

public class LevelOrderTraversal {

    public static void LevelOrderRecursive(BinaryTreeNode root) {
        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }

    public static int getHeight(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }
        return rightHeight + 1;
    }

    private static void printGivenLevel(BinaryTreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static void levelOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //queue.offer(null);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();

            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
    }

}
