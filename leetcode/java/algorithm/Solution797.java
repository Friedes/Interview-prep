package leetcode.java.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * All Paths From Source to Target : Algorithm Day 8 > 8 Dec 2022
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        int n = graph.length;
        if (n == 0)
            return allPaths;
        Deque<List<Integer>> stack = new ArrayDeque<>();
        List<Integer> source = new ArrayList<>();
        source.add(0);
        stack.push(source);
        int destination = n - 1;

        while (!stack.isEmpty()) {
            List<Integer> path = stack.pop();
            int size = path.size();

            if (path.get(size - 1) == destination) {
                allPaths.add(path);
            }

            int[] neighbors = graph[path.get(size - 1)];
            for (int i = 0; i < neighbors.length; i++) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(neighbors[i]);
                stack.push(newPath);
            }
        }

        return allPaths;
    }
}
