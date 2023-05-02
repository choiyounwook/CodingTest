import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
/**
		 * 프로세스
		 * 프로세스 관리 규칙
		 * 	1. 실행 대기 큐에서 대기 중인 프로세스 하나를 꺼낸다
		 *  2. 큐에 대기 중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣는다.
		 *  3. 만약 그런 프로레스가 없다면 방금 꺼낸 프로세스를 실행한다.
		 *  	3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료된다.
		 * */
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < priorities.length; i++) {
			queue.add(i);
		}
        
        while(!queue.isEmpty()) {
        	int max = 0;
        	for(int i:queue)
        	{
        		max = Math.max(max,priorities[i]);
        	}
        	int cur = 0;
        	while(!queue.isEmpty())
        	{
        		cur = queue.poll();
        		
        		if(max == priorities[cur]) {
        			
        			answer++;
        			break;
        		}
        		queue.add(cur);
        	}
        	if(location == cur) break;
        	
        }
        return answer;
    }
}