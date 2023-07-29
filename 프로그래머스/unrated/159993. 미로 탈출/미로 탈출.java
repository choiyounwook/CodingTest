import java.util.*;
class Solution {
   static class Miro{
		int x;
		int y;
		int cnt;
		
		public Miro(int x, int y, int cnt) {
			
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static int solution(String[] maps) {
		
		/**
		 * 미로 탈출
		 * S : 시작 지점
		 * E : 출구
		 * L : 레버
		 * O : 통로
		 * X : 벽
		 * 
		 * 미로를 탈출하는 최소 시간 구하기 - 최단거리이기 때문에 bfs
		 * 시작 지점 to 레버까지의 최단 거리 + 레버 to 출구의 최단 거리 =  정답
		 * */
        int answer = -1;
       
       int ans1 =bfs('S','L',maps);
       if(ans1 == -1) return ans1;
       int ans2 =bfs('L','E',maps);
       if(ans2 == -1) return ans2;

        return ans1 +ans2;
    }
	
	static int bfs(Character start, Character end, String[] maps) {
		 Queue<Miro> queue = new LinkedList<Miro>();
		 boolean[][] checkMap = new boolean[maps.length][maps[0].length()];
		 Character tmp;
		 if(end=='L') tmp = 'E';
		 else tmp = 'S';
		 
		 int[] dirx = {-1, 1, 0, 0};
	     int[] diry = {0, 0, -1, 1};
	     for (int i = 0; i < maps.length; i++) {
	    	 for (int j = 0; j < maps[i].length(); j++) {
				if(maps[i].charAt(j)==start) {
					queue.add(new Miro(i, j, 0));
				}
			}
	     }
	        
	        
	     while(!queue.isEmpty())
	     {

	    	 Miro m = queue.poll();
	        	
	        	for (int i = 0; i < 4; i++) {
					int newx = m.x + dirx[i];
					int newy = m.y + diry[i];
					

					// 범위 밖인 경우
					if(newx<0 || newy <0 || newx>=maps.length || newy >= maps[0].length() || checkMap[newx][newy]) continue;

					if(maps[newx].charAt(newy) == 'O' || maps[newx].charAt(newy) == tmp)
					{// 통로인 경우
						queue.add(new Miro(newx, newy, m.cnt+1));
						checkMap[newx][newy] = true;
					}else if(maps[newx].charAt(newy) == end)
					{// 레버이거나 출구인 경우
						return m.cnt+1;
					}
				}
	        }
	        return -1;
	}
}