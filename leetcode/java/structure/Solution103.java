package leetcode.java.structure;

import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Zigzag Level Order Traversal : Data structure Day 15 > 15 Nov 2022
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        zigzagOrderHelper(output, root, 0);
        return output;
    }

    public void zigzagOrderHelper(List<List<Integer>> output, TreeNode root, int level) {
        if (root == null) {
            return;
        } else {
            if (level >= output.size()) {
                output.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                output.get(level).add(root.val);
            } else {
                output.get(level).add(0, root.val);
            }
            zigzagOrderHelper(output, root.left, level + 1);
            zigzagOrderHelper(output, root.right, level + 1);
        }
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
