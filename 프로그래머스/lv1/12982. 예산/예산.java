import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        /**
		 * budget : 예산
		 * d : 각 부서별로 신청한 금액 배열
		 * 리턴 : 최대 지원 가능한 부서의 수
		 * */
        int answer = 0;
        int total = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
			if(total+d[i]<=budget) {
				answer++;
				total+=d[i];
			}
		}
        return answer;
    }
}