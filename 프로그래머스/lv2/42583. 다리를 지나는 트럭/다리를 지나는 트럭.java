import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

		/**
		 * 다리를 지나는 트럭
		 * 
		 * - 모든 트럭이 다리를 건너는게 걸리는 최소 시간 구하기
		 * 
		 * bridge_length : 다리에 올라갈 수 있는 최대 트럭 수
		 * weight : 다리가 견딜 수 있는 무게 (weight 이하까지만 감당 가능)
		 * truck_weights : 대기 중인 트럭들의 무게
		 * 
		 * Queue 사용
		 * 
		 * */
        int answer = 1;
        int curWeight = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 1; i < bridge_length; i++) {
			queue.add(0);
		}
        for (int i = 0; i < truck_weights.length; i++) {
    		// 다리에 자리 있는데, 용량이 안됨 &다리에 자리 없음
    		while(queue.size()>=bridge_length||curWeight+truck_weights[i]>weight) {
    			int tmp = queue.poll();
    			curWeight-=tmp;
    			answer++;
    		}
    		for (int j = queue.size(); j < bridge_length-1; j++) {
    			queue.add(0);
			}
        	// 다리에 자리 있음, 가능
    		queue.add(truck_weights[i]);
    		curWeight+=truck_weights[i];

        	
		}
        return answer+queue.size();
    }
}