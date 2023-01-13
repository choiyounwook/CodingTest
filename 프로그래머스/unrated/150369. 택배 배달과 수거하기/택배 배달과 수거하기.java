import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
      /**
		 * cap : 트럭이 실을 수 있는 최대 택배 상자
		 * n : 배달할 집의 수
		 * deliveries : 각 집에 배달할 택배 상자 수
		 * pickups : 각 집에서 수거할 택배 상자 수
		 * */
        long answer = 0;
        Stack<Integer> dstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();
        for (int i = 0; i < n; i++) {
			if(deliveries[i]!=0) dstack.push(i+1);
		}
        for (int i = 0; i < n; i++) {
			if(pickups[i]!=0) pstack.push(i+1);
		}
        
        while(!(dstack.isEmpty()&&pstack.isEmpty())){
        	if(!dstack.isEmpty()&&!pstack.isEmpty())
        		answer+=Math.max(dstack.peek()*2, pstack.peek()*2);
        	else if(!dstack.isEmpty())
        		answer+=(dstack.peek()*2);
        	else
        		answer+=(pstack.peek()*2);

        	
        	int box = 0;
        	
        	// 배달하기
        	while(!dstack.isEmpty())
        	{
        		box+=deliveries[dstack.peek()-1];
        		if(box>cap) {
        			deliveries[dstack.peek()-1] = box-cap;
        			 break;
        		}
        		dstack.pop();
        	}
        	
        	box = 0;
        	
        	// 수거하기
        	
        	while(!pstack.isEmpty()) {
        		box+=pickups[pstack.peek()-1];
        		if(box>cap) {
        			pickups[pstack.peek()-1] = box-cap;
        			break;}
        		pstack.pop();
        	}
        }
        return answer;
    }
}