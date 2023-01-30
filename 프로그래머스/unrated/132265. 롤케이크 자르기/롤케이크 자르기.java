import java.util.*;
class Solution {
    public int solution(int[] topping) {
        /**
		 * 롤케이크 자르기
		 * 
		 * topping : 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열
		 * 롤케이크를 공평하게 자르는 방법의 수 구하기
		 * */
        int answer = 0;
        
        HashMap<Integer,Integer> m1 = new HashMap<>(); // 철수
        HashMap<Integer,Integer> m2 = new HashMap<>(); // 동생
        
        for (int i = 0; i < topping.length; i++) {
			m1.put(topping[i], m1.getOrDefault(topping[i], 0)+1);
		}
        
        for (int i = 0; i < topping.length; i++) {
			
        	m2.put(topping[i], m2.getOrDefault(topping[i], 0)+1);
        	m1.put(topping[i], m1.getOrDefault(topping[i], 0)-1);
        	if(m1.get(topping[i])<1) m1.remove(topping[i]);
        	
        	if(m1.size()==m2.size()) answer++;
		}
        return answer;
    }
}