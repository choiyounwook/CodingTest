class Solution {
    public int[] solution(String s) {
		
		/**
		 * 이진 변환 반복하기
		 * x의 모든 0을 제거합니다.
		 * x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
		 * 
		 * return 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수
		 * */
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
        	answer[0]++;
        	int beforeStr=s.length();
        	s=s.replaceAll("0", "");
        	int afterStr=s.length();
        	answer[1]+=(beforeStr-afterStr);
        	int size = s.length();
        	s=Integer.toBinaryString(size)+"";
        }
        
        return answer;
    }
}