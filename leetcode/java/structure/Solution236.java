package leetcode.java.structure;

/*
 * Lowest Common Ancestor of a Binary Tree : Data structure Day 18 > 18 Nov 2022
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left_node = lowestCommonAncestor(root.left, p, q);
        TreeNode right_node = lowestCommonAncestor(root.right, p, q);
        if (left_node != null && right_node != null)
            return root;
        return left_node != null ? left_node : right_node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
