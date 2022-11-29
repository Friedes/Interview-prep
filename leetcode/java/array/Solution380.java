package leetcode.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * Insert Delete GetRandom O(1) : Daily > 29 Nov 2022
 */
// class RandomizedSet {
public class Solution380 {
    Random rand;
    private HashMap<Integer, Integer> map;
    private List<Integer> list;

    // public RandomizedSet() {
    public Solution380() {
        rand = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int delete_ind = map.get(val);
            int last_list_ele = list.get(list.size() - 1);
            list.set(delete_ind, last_list_ele);
            map.put(last_list_ele, delete_ind);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int random_ind = rand.nextInt(list.size());
        return list.get(random_ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */