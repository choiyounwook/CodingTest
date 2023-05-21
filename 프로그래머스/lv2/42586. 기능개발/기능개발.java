import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
 /**
         * 기능 개발
         * 
         * progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
         * speeds :각 작업의 개발 속도
         * 
         * 큐 사용
         * */
		List<Integer> list = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		int[] devDay = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++) {
			int remain = 100 - progresses[i];
			devDay[i] = remain/speeds[i];
			if(remain%speeds[i]!=0) devDay[i]++;
			list.add(i);
		}
		
		while(!list.isEmpty()) {
			int cnt = 0;
			int day = devDay[list.get(0)];
			for (int i = 0; i < list.size(); i++) {
				int idx = list.get(i);
				if(day>= devDay[idx])
				{
					cnt++;
					list.remove(i);
					i--;
				}else break;
			}
			ans.add(cnt);
		}
		
        return ans.stream().mapToInt(i->i).toArray();
    }
}