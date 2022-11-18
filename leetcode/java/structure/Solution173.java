package leetcode.java.structure;

import java.util.Collections;
import java.util.Stack;

/*
 * Binary Search Tree Iterator : Data structure Day 17 > 17 Nov 2022
 */
public class Solution173 {

  Stack<Integer> s = new Stack<>();

  //   public BSTIterator(TreeNode root) {
  public Solution173(TreeNode root) {
    in(root);
    Collections.reverse(s);
  }

  public int next() {
    return s.pop();
  }

  public boolean hasNext() {
    return !s.isEmpty();
  }

  public void in(TreeNode root) {
    if (root == null) return;
    in(root.left);
    s.push(root.val);
    in(root.right);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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
