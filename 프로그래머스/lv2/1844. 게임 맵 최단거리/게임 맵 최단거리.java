import java.util.*;
class Solution {
public static int solution(int[][] maps) {
		/**
		 * 게임 맵 최단거리
		 * 
		 * 이동 가능 : 동서남북 한칸
		 * 1 : 이동 가능
		 * 0 : 벽
		 * bfs로 풀기
		 * */
		int n = maps.length;
		int m = maps[0].length;
		Queue<Integer> x = new LinkedList<>();
		Queue<Integer> y = new LinkedList<>();
		int visited[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = -1;
			}
		}
		int dicX[] = {0, 0, 1, -1};
		int dicY[] = {1, -1, 0, 0};
		visited[0][0]=1;
		x.add(0);
		y.add(0);
		
		while(!x.isEmpty()) {
			int curx = x.poll();
			int cury = y.poll();
			
			for (int i = 0; i < 4; i++) {
				int newx = curx + dicX[i];
				int newy = cury + dicY[i];
				int cnt = visited[curx][cury]+1;
				if(newx<0||newy<0||newx>=n||newy>=m||maps[newx][newy]==0) continue;

				if(visited[newx][newy]==-1||visited[newx][newy]>cnt)
				{
					visited[newx][newy]=cnt;
					x.add(newx);
					y.add(newy);

				}
			}
		}	
		
        return visited[n-1][m-1];
    }
}