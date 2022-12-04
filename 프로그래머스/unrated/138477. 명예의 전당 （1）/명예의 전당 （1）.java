import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
         int[] answer = new int[score.length];
        List<Integer> topList = new ArrayList();
        
        for (int i = 0; i < score.length; i++) {
			if(topList.size()<k)
			{
				topList.add(score[i]);
				topList.sort(Collections.reverseOrder());
				answer[i] = topList.get(topList.size()-1);
			}else {
				topList.add(score[i]);
				topList.sort(Collections.reverseOrder());
				answer[i] = topList.get(k-1);
			}
		}
        return answer;
    }
}