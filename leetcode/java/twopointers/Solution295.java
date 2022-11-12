package leetcode.java.twopointers;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Find Median from Data Stream : Challenge > 12 Nov 2022
 */
public class Solution295 {
    PriorityQueue<Integer> maxheap, minheap;

    // public MedianFinder() {
    public Solution295() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxheap.isEmpty()||maxheap.peek()>=num)
            maxheap.add(num);
        else
            minheap.add(num);
    
        if(maxheap.size()>minheap.size()+1)
            minheap.add(maxheap.poll());
        else if(maxheap.size()<minheap.size())
            maxheap.add(minheap.poll());
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size())
            return (maxheap.peek()+minheap.peek())/2.0;
        return maxheap.peek();
    }
}
