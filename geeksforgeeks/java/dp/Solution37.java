package geeksforgeeks.java.dp;

import java.util.PriorityQueue;

/*
 * k-th smallest element in BST : Daily 07 Dec 2022
 */
public class Solution37 {
    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        InOrderTraversal(root, pq);
        int element = -1;
        if (K > pq.size()) {
            return -1;
        }
        while (K > 0) {
            element = pq.poll();
            K--;
        }
        return element;
    }

    public static void InOrderTraversal(Node root, PriorityQueue<Integer> pq) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, pq);
        pq.add(root.data);
        InOrderTraversal(root.right, pq);
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}