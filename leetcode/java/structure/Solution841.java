package leetcode.java.structure;

import java.util.List;

/*
 * Keys and Rooms : Data structure Day 19 > 19 Nov 2022
 */
public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public static void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room])
            return;
        visited[room] = true;
        List<Integer> keys = rooms.get(room);
        for (int i = 0; i < keys.size(); i++) {
            if (visited[keys.get(i)])
                continue;
            dfs(rooms, visited, keys.get(i));
        }
    }
}
