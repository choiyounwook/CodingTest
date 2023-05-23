import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
/**
		 * 더 맵게
		 * 제일 안 매운 음식 + (두번째로 안 매운 음식 *2) = 섞은 음식
		 * 
		 * 모든 음식의 스코빌 지수가 K 이상이 될때까지 반복
		 * 
		 * 최소 힙을 이용해 제일 작은 수 찾기
		 * */
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
        	heap.add(scoville[i]);
		}
        while(heap.size()>=2&&heap.peek()<K)
        {
        	answer++;
        	int first = heap.poll();
        	int second = heap.poll()*2;
        	heap.add(first+second);
        }
        if(heap.isEmpty()||heap.peek()<K) return -1;
        
        return answer;
    }
}