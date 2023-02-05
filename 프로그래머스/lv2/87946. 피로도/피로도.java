class Solution {
    static int answer = 0;
	static int[][] dungeon;
	public static int solution(int k, int[][] dungeons) {
        /**
         * 피로도
         * 0 : 최소 피로도 (던전 탐험 시 가지고 있어야 하는 최소 피로도)
         * 1 : 소모 피로도 (던전 탐험 후 소모되는 피로도)
         * */
		dungeon = dungeons;
		dfs(k, new boolean[dungeons.length], 0,0);
        return answer;
    }
	public static void dfs(int k, boolean check[], int cnt, int ans) {
		if(check.length<=cnt)
		{
			answer= Math.max(answer, ans);
			return;
		}else {
			for (int i = 0; i < check.length; i++) {
				if(check[i]) continue;
				check[i]= true;
				if(dungeon[i][0]<=k)
					dfs(k-dungeon[i][1], check, cnt+1, ans+1);
				else
					dfs(k, check, cnt+1, ans);
				check[i]= false;
			}
		}
	}
}