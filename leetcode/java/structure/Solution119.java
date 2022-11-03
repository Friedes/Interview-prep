package leetcode.java.structure;

import java.util.ArrayList;
import java.util.List;

/*
 * Pascal's Triangle II : Data structure Day 3 > 02 Nov 2022
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(temp);
        }

        return list.get(rowIndex);
    }
}
