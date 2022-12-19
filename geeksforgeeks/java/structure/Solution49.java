package geeksforgeeks.java.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Articulation Point - I : Daily > 16 Dec 2022
 */
public class Solution49 {
    class Node implements Comparator<Node> {
        int v;
        int weight;

        Node() {
        }

        Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int compare(Node node1, Node node2) {
            if (node1.weight < node2.weight)
                return -1;
            if (node1.weight > node2.weight)
                return 1;
            return 0;
        }
    }

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        n = n + 1;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Node>());
        }

        for (int[] a : flights) {
            adj.get(a[0]).add(new Node(a[1], a[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());
        pq.add(new Node(k, 0));
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            for (Node it : adj.get(p.v)) {
                if (dist[p.v] + it.weight < dist[it.v]) {
                    dist[it.v] = dist[p.v] + it.weight;
                    pq.add(new Node(it.v, dist[it.v]));
                }
            }
        }

        int max = dist[1];
        for (int i = 1; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            if (max < dist[i]) {
                max = dist[i];
            }
        }
        return max;
    }
}
