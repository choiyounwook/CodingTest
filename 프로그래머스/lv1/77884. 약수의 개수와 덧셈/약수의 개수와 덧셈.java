class Solution {
    public int solution(int left, int right) {
         int answer = 0;
        
        // left ~ right 약수 구하기
        for (int i = left; i <=right; i++) {
			int cnt = 0;
			// i의 약수 개수 구하기
			for (int j = 1; j <= i; j++) {
				if(i%j==0)cnt++;
			}
			answer+=(cnt%2==0?i:-i);
		}
        return answer;
    }
}