package leetcode.java.structure;

import java.util.Arrays;

import leetcode.java.Solution;

/*
 * Design HashMap : Data structure Day 2 > 02 Nov 2022
 */
public class Solution706 implements Solution{
    public String testResult(){
        return "";
    }
}

class MyHashMap {
    private int size = (int)Math.pow(10, 6) + 1;
    private int[] store = new int[size];

    public MyHashMap() {
        Arrays.fill(store,-1);
    }
    
    public void put(int key, int value) {
        this.store[key] = value;
    }
    
    public int get(int key) {
        return this.store[key];
    }
    
    public void remove(int key) {
        this.store[key] = -1;
    }
}
