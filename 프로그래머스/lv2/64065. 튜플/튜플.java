import java.util.*;
class Solution {
    public static Integer[] solution(String s) {
    	/**
    	 * 튜플
    	 * 
    	 * 튜플의 성징
    	 * 1. 중복된 원소가 있을 수 있음
    	 * 2. 원소에 정해진 순서가 있음 -> 원소의 순서가 다르면 서로 다른 튜플
    	 * 
    	 * */
    	ArrayList<Integer> ans = new ArrayList<>();
        s = s.substring(1,s.length()-2);
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("\\},", " ");
        String[] tuples = s.split(" ");
        Arrays.sort(tuples, (a,b)->{
        	return a.length() - b.length();
        });
        for(String str : tuples) {
        
        	String[] tuple = str.split(",");
        	for (int i = 0; i < tuple.length; i++) {
				int num = Integer.parseInt(tuple[i]);
				if(!ans.contains(num)) 
				{ 
					ans.add(num);
				}
			}
        }
        return ans.toArray(new Integer[ans.size()]);
    }
}