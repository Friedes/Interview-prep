package leetcode.java.dp;

/*
 * Range Sum of BST : Daily 7 Dec 2022
 */
public class Solution938 {
    static int sum = 0;
    static int low_ = 0;
    static int high_ = 0;

    public void SumBST(TreeNode root) {
        if (root == null)
            return;
        if (root.val < low_) {
            SumBST(root.right);
        } else if (root.val > high_) {
            SumBST(root.left);
        } else {
            sum += root.val;
            SumBST(root.right);
            SumBST(root.left);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        low_ = low;
        high_ = high;
        SumBST(root);
        return sum;
    }
}

class TreeNode {
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