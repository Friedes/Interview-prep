package leetcode.java.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * Sort Characters By Frequency : Daily > 21 Nov 2022
 */
public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> store = new TreeMap<>();
        for (Character c : s.toCharArray()) {
            store.merge(c, 1, Integer::sum);
        }
        return store.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(x -> {
            int val = x.getValue();
            String str = "";
            for (int i = 0; i < val; i++) {
                str = str + x.getKey();
            }
            return str;
        }).collect(Collectors.joining());
    }

    public String frequencySort2(String s) {
        int[] arr=new int[128];
		for(char c:s.toCharArray()){
			arr[c]++;
		}

		HashMap<Integer,List<Character>> map=new HashMap<>();

		for(int i=0;i<128;i++){
			if(arr[i]!=0){
				List<Character> l=map.getOrDefault(arr[i],new ArrayList<>());
				l.add((char)i);
				map.put(arr[i],l);
			}
		}

		TreeSet<Integer> t= new TreeSet<Integer>(map.keySet());
		t=(TreeSet<Integer>)t.descendingSet();

		StringBuilder sb=new StringBuilder();

		for(Integer i:t){
			List<Character> c=map.get(i);

			for(Character ch:c){
				for(int j=0;j<i;j++){
					sb.append(ch);
				}
			}
		}
		return sb.toString();
    }
}
