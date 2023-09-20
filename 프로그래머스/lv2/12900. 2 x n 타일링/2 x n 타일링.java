class Solution {
    public int solution(int n) {
       /**
		 * 2 x n 타일링
		 * 
		 * dfs로 문제 풀 경우 - 시간 초과
		 * dp 문제
		 * */
    	int[] dp = new int[n];
    	if(n==1 || n==2) return n;
    	dp[0]=1;
    	dp[1]=2;
    	for (int i = 2; i < n; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%1000000007;
		}

        return dp[n-1];
    }
}