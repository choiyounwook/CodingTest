class Solution {
    public String solution(int n, int t, int m, int p) {
/**
		 * n진수 게임
		 * 
		 * n : 진법(1~16)
		 * t : 미리 구할 숫자의 갯수
		 * m : 게임에 참가하는 인원
		 * p : 튜브의 순서
		 * */
        String answer = "";
        int number = 0;
        String total = Integer.toString(number++, n).toUpperCase();
        
        for (int i = 0; i <t; i++) {
			int idx = p + (m*i);
			while(total.length()<idx) {
				total+=Integer.toString(number++, n).toUpperCase();
			}
			answer+=total.charAt(idx-1);
		}
        return answer;
    }
}