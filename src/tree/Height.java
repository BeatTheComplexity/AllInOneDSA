package tree;

import tree.node.BinaryTreeNode;

public class Height {

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
}
