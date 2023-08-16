import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
/**
		 * 카카오프렌즈 컬러링북
		 * */
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dirx = {-1, 1, 0, 0};
        int[] diry = {0, 0, -1, 1};
        boolean[][] checkMap = new boolean[m][n];
        Stack<Integer> stackX = new Stack<>();
        Stack<Integer> stackY = new Stack<>();
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(checkMap[i][j] || picture[i][j]==0) continue;
				
				stackX.add(i);
				stackY.add(j);
				checkMap[i][j]=true;
				int cnt = 0;
				while(!stackX.isEmpty()) {
					
					int x = stackX.pop();
					int y = stackY.pop();
					cnt++;
					
					for (int k = 0; k < 4; k++) {
						int newx = x + dirx[k];
						int newy = y + diry[k];
						
						if(newx<0||newy<0||newx>=m||newy>=n||checkMap[newx][newy]||picture[newx][newy]!=picture[x][y]) continue;
						stackX.add(newx);
						stackY.add(newy);
						checkMap[newx][newy]=true;
						
					}
				}
				numberOfArea++;
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
			}
		}
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}