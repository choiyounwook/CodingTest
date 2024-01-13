import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
/**
		 * 프로그래머스 스코빌 지수 level 1
		 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
		 * 
		 * return 섞어야 하는 최소 수 (K 이상 만들 수 없다면 -1)
		 * */
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o1-o2);
        
        for (int i = 0; i < scoville.length; i++) {
			queue.add(scoville[i]);
		}
        
        while(!queue.isEmpty()&&queue.peek()<K) {
        	if(queue.size()<2) {
        		return -1;
        	}
        	int num1 = queue.poll();
        	int num2 = queue.poll();
        	answer++;
        	queue.add(num1+(num2*2));
        }
        return answer;
    }
}