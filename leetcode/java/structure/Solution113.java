package leetcode.java.structure;

import java.util.ArrayList;
import java.util.List;

/*
 * Path Sum II : Data structure Day 16 > 16 Nov 2022
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        this.findValidPath(root, targetSum, 0, list1, list2);
        return list1;
    }

    public void findValidPath(TreeNode nn, int targetSum, int sum, List<List<Integer>> list1, List<Integer> list2) {
        if (nn == null)
            return;
        if (nn.left == null && nn.right == null) {
            if (sum + nn.val == targetSum) {
                list2.add(nn.val);
                list1.add(new ArrayList<>(list2));
                list2.remove(list2.size() - 1);
                return;
            }
            return;

        }

        list2.add(nn.val);
        findValidPath(nn.left, targetSum, sum + nn.val, list1, list2);
        findValidPath(nn.right, targetSum, sum + nn.val, list1, list2);
        list2.remove(list2.size() - 1);
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
