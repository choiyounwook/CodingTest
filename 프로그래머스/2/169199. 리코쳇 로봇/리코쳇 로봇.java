import java.util.*;
class Solution {
    public int solution(String[] board) {
/**
		 * 리코쳇 로봇
		 * 이동 방향 : 상, 하, 좌, 우 - 벽이랑 장애물을 만나야 멈춤
		 * . : 빈 공간
		 * R : 로봇의 처음 위치
		 * D : 장애물 위치
		 * G : 목표지점
		 * 
		 * bfs 문제
		 * */
        int answer = -1;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int maxX = board.length;
        int maxY = board[0].length();
        
        boolean[][] visited = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
			String str = board[i];
			for (int j = 0; j < maxY; j++) {
				if(str.charAt(j)=='R') {
				
					queue.add(new int[] {i, j, 0});
					visited[i][j] = true;
					break;
				}
			}
		}
        
        while(!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	
        	int x = cur[0];
        	int y = cur[1];
        	int cnt = cur[2];
        	System.out.println(x+ " " + y);
        	if(board[x].charAt(y)=='G') return cnt;
        	for (int i = 0; i < 4; i++) {
        		int newx = x;
        		int newy = y;
        		while(newx+dx[i]>=0 && newy+dy[i]>=0 && newx+dx[i] < maxX && newy+dy[i] < maxY && board[newx+dx[i]].charAt(newy+dy[i])!='D') {
        			newx+=dx[i];
        			newy+=dy[i];
        		}
				if(!visited[newx][newy])
				{
					visited[newx][newy] = true;
					queue.add(new int[] {newx, newy, cnt+1});
				}
			}
        }
        return answer;
    }
}