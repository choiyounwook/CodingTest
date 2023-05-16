import java.util.*;
class Solution {
	public static String solution(int[] numbers) {
		/**
		 * 가장 큰 수
		 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내라.
		 * dfs로 정렬 시 메모리 초과 이슈 발생 
		 * num 중 앞에 있는 숫자의 크기가 큰 num이 제일 먼저 와야 큰 수가 됨
		 * */
		String answer = "";
		String[] nums = new String[numbers.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers[i]+"";
		}
		Arrays.sort(nums,(o2,o1)->(o1+o2).compareTo(o2+o1));
		if(nums[0].equals("0")) return "0";
		for (int i = 0; i < nums.length; i++) {
			answer+=nums[i];
		}
        return answer;
    }
}