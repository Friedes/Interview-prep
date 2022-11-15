package leetcode.java.structure;

/*
 * Convert Sorted Array to Binary Search Tree : Data structure Day 15 > 15 Nov 2022
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearchTree(nums, 0, nums.length - 1);
    }

    TreeNode binarySearchTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = binarySearchTree(nums, l, mid - 1);
        root.right = binarySearchTree(nums, mid + 1, r);
        return root;
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
