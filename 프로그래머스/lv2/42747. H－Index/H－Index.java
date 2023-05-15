import java.util.*;
class Solution {
    public int solution(int[] citations) {
/**
    	 * H-index
    	 * 
    	 * citations의 수(n) : 과학자가 발표한 논문 수
    	 * 각 인덱스 내용 : 논문별 인용 횟수
    	 * 
    	 * n편 논문 중 h번 이상 인용된 논문이 h편 이상인 h 값
    	 * */
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
			int h = citations.length-i;
			int cnt = 0;
			if(citations[i]>=h) return h;
		}
        return answer;
    }
}