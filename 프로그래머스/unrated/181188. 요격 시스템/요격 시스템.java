import java.util.*;
class Solution {
    public int solution(int[][] targets) {
/**
		 * 요격 시스템
		 * 
		 * 1인덱스를 내림차순으로 정렬
		 * */
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2)->{return o1[1]-o2[1];});
        
        int cur = -1;
        
        for(int[] t : targets) {
        	if(t[0]>= cur)
        	{
        		answer++;
        		cur = t[1];
        	}
        }
        return answer;
    }
}