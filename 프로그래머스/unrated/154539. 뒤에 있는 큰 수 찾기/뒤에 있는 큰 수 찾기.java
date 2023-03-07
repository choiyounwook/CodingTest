import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
		/**
		 * 뒤에 있는 큰 수 찾기
		 * 자신보다 뒤에 있는 숫자 중에 자신보다 크면서 가장 가까이에 있는 수 찾기 없으면 -1
		 * 단순 배열 순회 시 시간 초과 발생 -> stack 사용으로 해결
		 * */
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
			if(stack.isEmpty()) stack.push(i);
			else {
				while(!stack.isEmpty()&&numbers[stack.peek()]<numbers[i]) {
					answer[stack.pop()] = numbers[i];
				}
				stack.push(i);
			}
		}
        while(!stack.isEmpty()) answer[stack.pop()]=-1;
        
        return answer;
    }
}