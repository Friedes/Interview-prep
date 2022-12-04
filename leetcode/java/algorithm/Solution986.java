package leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * Interval List Intersections : Algorithm Day 4 > 4 Dec 2022
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> intersections = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int[] ithInterval = firstList[i];
            int[] jthInterval = secondList[j];

            if (ithInterval[1] < jthInterval[0]) { // no intersection
                i++;
            } else if (ithInterval[0] > jthInterval[1]) { // intersection
                j++;
            } else { // intersection
                int max = ithInterval[0], min = ithInterval[1];
                if (max < jthInterval[0])
                    max = jthInterval[0];
                if (min > jthInterval[1])
                    min = jthInterval[1];
                intersections.add(new int[] { max, min });
                if (ithInterval[1] < jthInterval[1])
                    i++;
                else
                    j++;
            }
        }

        return intersections.toArray(new int[0][]);
    }
}
