import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
/**
		 * 의상
		 * 
		 * 동일한 의류 카테고리 별로 해당 의류의 개수 체크
		 * 
		 * */
        int answer = 1;
        
        Map<String,Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
       	Iterator<String> keys = map.keySet().iterator();
       	while(keys.hasNext()) {
       		String key = keys.next();
       		answer*=(map.get(key)+1);
       	}
        return answer-1;
    }
}