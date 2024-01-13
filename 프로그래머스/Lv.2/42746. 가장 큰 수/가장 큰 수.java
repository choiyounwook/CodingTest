import java.util.*;
class Solution {
	public static String solution(int[] numbers) {
		/**
		 * 프로그래머스 level 2 가장 큰 수
		 * 
		 * */
        String answer = "";
        String[] strNumber = new String[numbers.length];
        
        for (int i = 0; i < strNumber.length; i++) {
        	strNumber[i] = numbers[i]+"";
		}
        
        Arrays.sort(strNumber,(o1,o2)->(o2+o1).compareTo(o1+o2));
        for (int i = 0; i < strNumber.length; i++) {
			answer+=strNumber[i];
		}
        return answer.startsWith("0")?"0":answer;
    }
}