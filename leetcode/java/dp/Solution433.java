package leetcode.java.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.java.Solution;

/*
 * Minimum Genetic Mutation : Daily 02 Nov 2022
 */
public class Solution433 implements Solution{
    
    char allowed[] = {'A','C','G','T'};
    public int minMutation(String start, String end, String[] bank) {
        int count = -1;
        Queue<String> que = new LinkedList<>();
        que.add(start);
        List<String> bankList = Arrays.asList(bank);
        HashSet<String> visited = new HashSet<>();
        while(!que.isEmpty()) {
            int size = que.size();
            count++;
            while(size-->0) {
                String c = que.remove();
                if(c.equals(end)) {
                    return count;
                }
                char curr[] = c.toCharArray();
                for(char a : allowed) {
                    for(int i=0;i<curr.length;i++) {
                        if(curr[i] != a) {
                            char t = curr[i];
                            curr[i] = a;
                            String val = new String(curr);
                            if(!visited.contains(val) && 
                                    bankList.contains(val)) {
                                visited.add(val);
                                que.add(val);
                            }
                            curr[i] = t;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public String testResult(){
        return "";
    }
}
