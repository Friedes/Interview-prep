package leetcode.java.structure;

/*
 * Serialize and Deserialize Binary Tree : Data structure Day 18 > 18 Nov 2022
 */
public class Solution297 {
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        sb.append("[");
        doSerialize(root);
        sb.append("]");
        return sb.toString();
    }

    private void doSerialize(TreeNode root) {
        if (root == null)
            return;

        sb.append(root.val);
        sb.append(",");
        doSerialize(root.left);
        sb.append(",");
        doSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s.startsWith("["))
            s = s.substring(1, s.length() - 1);

        return doDeserialize(s, 0);
    }

    private int k = 0;

    public TreeNode doDeserialize(String s, int z) {
        if ("".equals(s)) {
            return null;
        }

        int i = z;
        while (i < s.length() && s.charAt(i) != ',')
            i++;
        String v = s.substring(z, i);

        if (v.equals("")) {
            k = i + 1;
            return null;
        }

        TreeNode n = new TreeNode(Integer.parseInt(v));
        n.left = doDeserialize(s, i + 1);
        n.right = doDeserialize(s, k);
        return n;
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
