import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
		}
       
        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2).compareTo(map.get(o1));
			}
		});
        for(int key : list) {
        	
        	answer++;
        	k-=map.get(key);
        	if(k<=0) break;
        }
        return answer;
    }
}