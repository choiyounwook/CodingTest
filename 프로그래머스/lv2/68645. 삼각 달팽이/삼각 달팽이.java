class Solution {
    public int[] solution(int n) {
        		int num=0;
		for (int i = 1; i <=n; i++) {
			num+=i;
		}
        int[] answer = new int[num];
        int[][] arr = new int[n][n];
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int cur = 1;
        int x=-1;
        int y=0;
        int dir=0;
        for (int i = n; i >0; i--,dir++) {
			for (int j = 0; j < i; j++) {
				x+=dx[dir%3];
				y+=dy[dir%3];
				arr[x][y]=cur++;
			}
		}
        cur=0;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==0) break;
				answer[cur++]=arr[i][j];
			}
		}
        return answer;
    }
}