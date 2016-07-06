package tree;

import tree.node.BinaryTreeNode;

public class SpiralTraversal {

    public static void spiralRecursive(BinaryTreeNode root) {
        int height = Height.getHeight(root);
        boolean isReverseDir = false;
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i, isReverseDir);
            isReverseDir = !isReverseDir;
        }
    }

    private static void printGivenLevel(BinaryTreeNode root, int level, boolean isReverseDir) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            if (isReverseDir) {
                printGivenLevel(root.right, level - 1, isReverseDir);
                printGivenLevel(root.left, level - 1, isReverseDir);
            } else {
                printGivenLevel(root.left, level - 1, isReverseDir);
                printGivenLevel(root.right, level - 1, isReverseDir);

            }
        }
    }
}
