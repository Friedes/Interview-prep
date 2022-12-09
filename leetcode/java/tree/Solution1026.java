package leetcode.java.tree;

/*
 * Maximum Difference Between Node and Ancestor : Daily 9 Dec 2022
 */
public class Solution1026 {

    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        checkDifference(root, root.val, root.val);
        return maxDiff;
    }

    public void checkDifference(TreeNode root, int max, int min) {
        if (root == null) {
            maxDiff = Math.max(maxDiff, max - min);
            return;
        }
        if (root.val <= min) {
            min = root.val;
        }
        if (root.val >= max) {
            max = root.val;
        }
        checkDifference(root.left, max, min);
        checkDifference(root.right, max, min);
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
