package leetcode.java.tree;

/*
 * Maximum Product of Splitted Binary Tree : Daily 10 Dec 2022
 */
public class Solution1339 {
    long result;

    public int maxProduct(TreeNode root) {
        long totalSum = totalSum(root);
        subTotal(root, totalSum);
        return (int) (result % ((int) Math.pow(10, 9) + 7));
    }

    public long totalSum(TreeNode root) {
        if (root == null)
            return 0l;
        long left = totalSum(root.left);
        long right = totalSum(root.right);
        return (left + right + root.val);
    }

    public long subTotal(TreeNode root, long totalProduct) {
        if (root == null)
            return 0l;
        long left = subTotal(root.left, totalProduct);
        long right = subTotal(root.right, totalProduct);
        long sub1 = (left + right + root.val);
        long sub2 = (totalProduct - sub1);
        result = Math.max(result, (sub1 * sub2));
        return sub1;
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
