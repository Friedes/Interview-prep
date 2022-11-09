package leetcode.java.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Online Stock Span : Daily 09 Nov 2022
 */
public class Solution901 {
    public static void main(int price){
        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(price);
        System.out.println(param_1);
    }
}

class StockSpanner {
    List<Integer> l;
    List<Integer> ans;
    Stack<Integer> st;

    public StockSpanner() {
        l = new ArrayList<>();
        ans = new ArrayList<>();
        st = new Stack<>();
    }
    
    public int next(int price) {
        while (!st.isEmpty() && l.get(st.peek()) <= price)
            st.pop();
        if (st.isEmpty())
            ans.add(l.size()+1);
        else
            ans.add(l.size()-st.peek());
        l.add(price);
        st.push(l.size()-1);
        return ans.get(ans.size()-1);
    }
}
