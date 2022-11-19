package geeksforgeeks.java.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Check if all levels of two trees are anagrams or not : Daily > 19 Nove 2022
 */
public class Solution19 {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(node1);
        q2.offer(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2)
                return false;

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            while (size1-- > 0) {
                Node curr1 = q1.poll();
                Node curr2 = q2.poll();

                sb1.append(curr1.data);
                sb2.append(curr2.data);

                if (curr1.left != null)
                    q1.offer(curr1.left);
                if (curr2.left != null)
                    q2.offer(curr2.left);
                if (curr1.right != null)
                    q1.offer(curr1.right);
                if (curr2.right != null)
                    q2.offer(curr2.right);
            }

            char[] chs1 = sb1.toString().toCharArray();
            Arrays.sort(chs1);
            char[] chs2 = sb2.toString().toCharArray();
            Arrays.sort(chs2);

            if (!Arrays.equals(chs1, chs2))
                return false;
        }

        if ((q1.isEmpty() && !q2.isEmpty()) || (!q1.isEmpty() && q2.isEmpty()))
            return false;

        return true;
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
