class Solution {
    public int solution(int n, int m, int[] section) {
                /**
         * n : 벽 길이
         * m : 롤러 길이
         * section : 칠해야 하는 벽 공간
         * 
         * return 롤러로 페인트칭해야 하는 최소 횟수 구하기
         * */
		int answer = 0;
		int cur =0;
		for (int i = 0; i < section.length; i++) {
			if(cur>=section[i]) continue;
			answer++;
			cur=section[i]+m-1;
		}
        return answer;
    }
}