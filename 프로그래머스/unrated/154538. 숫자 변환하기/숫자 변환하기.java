import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        /**
         * 숫자 변환하기
         * x를 y로 변환할 때 걸리는 최소 연산 횟수 구하기
         * x+n
         * x*2
         * x*3
         * 위 세가지만 가능
         * 만약 y 못 만들면 -1 반환
         * */
		int[] answer = new int[y+1];
		Queue<Integer> queue =new LinkedList<>();
		if(x==y) return 0;
		queue.add(x);
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			int num1 = num+n;
			if(num1<=y&&(answer[num1]>(answer[num]+1)||answer[num1]==0))
			{
				answer[num1]=answer[num]+1;
				queue.add(num1);
			}
			
			num1 = num*2;
			if(num1<=y&&(answer[num1]>(answer[num]+1)||answer[num1]==0))
			{
				answer[num1]=answer[num]+1;
				queue.add(num1);
			}
			num1 = num*3;
			if(num1<=y&&(answer[num1]>(answer[num]+1)||answer[num1]==0))
			{
				answer[num1]=answer[num]+1;
				queue.add(num1);
			}
		}
        return answer[y]==0?-1:answer[y];
    }
}