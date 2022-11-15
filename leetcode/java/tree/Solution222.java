package leetcode.java.tree;

/*
 * Count Complete Tree Nodes : Daily 15 Nov 2022
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int size = 0;
        int ls = countNodes(root.left);
        int rs = countNodes(root.right);

        size = size + ls + rs;
        return size + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
