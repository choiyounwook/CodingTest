import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         /*
         * 전체 학생 수 : n
         * 체육복 도난 당한 학생 : lost
         * 여벌 체육복 가져온 학생 : reserve
         * */
		int answer = 0;
		boolean[] check = new boolean[n+1];
		Arrays.sort(lost);
		Arrays.sort(reserve);
		// 초기화 (학생들이 체육복 가지고 있음)
		for (int i = 0; i < n+1; i++) {
			check[i]=true;
		}
		
		// 도난
		for (int i = 0; i < lost.length; i++) {
			check[lost[i]]=false;
		}
		
		// 도난 당했지만 여벌 옷 있음
		for (int i = 0; i < reserve.length; i++) {
			if(!check[reserve[i]]) {
				check[reserve[i]]=true;
				reserve[i] = 0;
			}
		}
		
		// 여벌 옷 나눔
		for (int i = 0; i < reserve.length; i++) {
			if(reserve[i]==0) continue;
			int student = reserve[i];
			if((student-1)>=1&&!check[student-1])
			{
				check[student-1]=true;
			}else if(student+1<=n&&!check[student+1]) {
				check[student+1]=true;
			}
		}
		for (int i = 1; i < check.length; i++) {
			if(check[i]) answer++;
		}
        return answer;
    }
}