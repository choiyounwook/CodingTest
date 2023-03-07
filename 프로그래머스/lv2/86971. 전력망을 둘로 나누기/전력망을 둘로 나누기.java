import java.util.*;
class Solution {
	public static boolean[][] map;
	public static int solution(int n, int[][] wires) {
		map = new boolean[n][n];
        int answer = n;
        
        // 전선들 연결
        for (int i = 0; i < wires.length; i++) {
			int x = wires[i][0]-1;
			int y = wires[i][1]-1;
			map[x][y]=true;
			map[y][x]=true;
		}
        
        // 하나씩 돌아가면서 전선 끊어보기
        for (int i = 0; i < wires.length; i++) {
			int x = wires[i][0]-1;
			int y = wires[i][1]-1;
			map[x][y]=false;
			map[y][x]=false;
			answer= Math.min(answer, bfs(n));
			// bfs
			map[x][y]=true;
			map[y][x]=true;
			
		} 
        return answer;
    }
	
	public static int bfs(int n) {
		boolean[] visited = new boolean[n];
		int cnt = 0;
		Stack<Integer> stack = new Stack<Integer>();
		visited[0]=true;
		stack.push(0);
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			cnt++;
			for (int i = 0; i < n; i++) {
				if(!map[cur][i]||visited[i]) continue;
				visited[i]=true;
				stack.push(i);
			}
		}

		return (cnt==n?-1:Math.abs(n-(cnt*2)));
	}
}