import java.util.*;
class Solution {
    public int solution(int[] order) {
        /**
		 * order : 택배 기사님이 원하는 상자의 순서
		 * */
        int answer = 0;
        Stack<Integer> belt = new Stack<Integer>();
        int cur = 0;
        for (int box = 1; box <= order.length; box++) {
        	// 메인 벨트 
        	if(box==order[cur]) {
        		 answer++;
        		 cur++;
        	 }else {
        		 belt.add(box);
        	 }
        	if(cur>=order.length) break;
        	// 보조 벨트
        	 while(!belt.isEmpty()&&belt.peek()==order[cur]) {
        		 answer++;
        		 cur++;
        		 belt.pop();
        		 if(cur>=order.length) break;
        	 }
        	 if(cur>=order.length) break;
        	 
		}
        
        return answer;
    }
}