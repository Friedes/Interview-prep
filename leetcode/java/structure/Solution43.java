package leetcode.java.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Multiply Strings : Data structure Day 8 > 08 Nov 2022
 */
public class Solution43 {
    public List<List<String>> groupAnagrams(String[] str) {
        int n=str.length;
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        List<List<String>> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            char [] ch=str[i].toCharArray();
            Arrays.sort(ch);
            String temp=new String(ch);
            if(hm.containsKey(temp)){
                hm.get(temp).add(str[i]);
            }else{
                ArrayList<String> t=new ArrayList<>();
                t.add(str[i]);
                hm.put(temp,t);
            }
        }
        
        for(String key:hm.keySet()){
            list.add(hm.get(key));
        }
        
        return list;
    }
}
