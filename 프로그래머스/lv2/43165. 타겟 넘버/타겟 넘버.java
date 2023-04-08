import java.util.*;
class Solution {
	public static int solution(int[] numbers, int target) {
		
		/**
		 * 타겟 넘버
		 * dfs
		 * */
		
		Stack<Pair> stack = new Stack();
        int answer = 0;
        int size = numbers.length;
        stack.push(new Pair(0, 0));
        while(!stack.isEmpty())
        {
        	Pair pair = stack.pop();
        	if(pair.idx >= size) {
        		if(pair.sum == target)answer++;
        		continue;
        		}
        	
        	stack.push(new Pair(pair.sum+numbers[pair.idx], pair.idx+1));
        	stack.push(new Pair(pair.sum-numbers[pair.idx], pair.idx+1));
        }
        return answer;
    }
	
	static class Pair{
		int sum;
		int idx;
		
		public Pair(int sum, int idx) {
			this.sum = sum;
			this.idx = idx;
		}
	}
}