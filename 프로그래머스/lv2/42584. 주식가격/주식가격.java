import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        /**
		 * 주식 가격
		 *  prices : 초 단위로 기록된 주식 가격
		 *  
		 *  가격이 떨어지지 않는  기간이 몇초인지 구하기
		 *  
		 *  이중 for문 사용 -> 시간이 오래 걸림
		 *  스택 사용
		 * */
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        // 가격이 떨어지는 경우 구하기
        for (int i = 0; i < prices.length; i++) {
        	while(!stack.isEmpty()&&prices[stack.peek()]>prices[i])
        	{
        		int idx = stack.pop();
        		answer[idx] = i-idx;
        		
        	}
        	stack.add(i);
		}
        // 가격이 안 떨어진 경우
        while(!stack.isEmpty()) {
        	int idx = stack.pop();
        	answer[idx] = answer.length-1-idx;
        }

        return answer;
    }
}