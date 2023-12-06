class Solution {
    public double solution(int[] numbers) {
        /**
		 * 배열의 평균값
		 * */
        double answer = 0;
        
       for (int i : numbers) {
		answer+=i;
       }
       
        return answer/numbers.length;
    }
}