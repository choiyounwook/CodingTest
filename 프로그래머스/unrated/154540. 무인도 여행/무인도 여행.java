import java.util.*;
class Solution {
    static class Pair implements Comparable<Pair>{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

	}
	public static int[] solution(String[] maps) {
		/**
		 * 무인도 여행
		 * 
		 * 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return
		 * 무인도가 없다면 -1
		 * 
		 * */
		int mapX = maps.length;
		int mapY =maps[0].length();
		boolean[][] mapCheck = new boolean[mapX][mapY]; // true인 경우 이미 체크한 섬의 읿부
		List<Integer> island = new ArrayList<Integer>();
		int[] dirx = {1,-1,0,0};
		int[] diry = {0,0,-1,1};
		for (int i = 0; i < mapX; i++) {
			for (int j = 0; j < mapY; j++) {
				// 섬이 아니거나 이미 체크한 곳이면 다음으로 넘어감
				if(maps[i].charAt(j)=='X'||mapCheck[i][j]) continue;
				int num = 0;
				mapCheck[i][j] = true;
				Stack<Pair> stack = new Stack<>();
				stack.push(new Pair(i, j));
				
				while(!stack.isEmpty()) {
					Pair cur = stack.pop();
					num += maps[cur.x].charAt(cur.y)-'0';
					for (int d = 0; d <4; d++) {
						int x = cur.x+dirx[d];
						int y = cur.y+diry[d];
						if(x<0||y<0||x>=mapX||y>=mapY||maps[x].charAt(y)=='X'||mapCheck[x][y]) continue;
						stack.add(new Pair(x, y));
						mapCheck[x][y]=true;
					}
				}
				island.add(num);
			}
		}
        int[] answer = {-1};
        if(!island.isEmpty()) {
            Collections.sort(island);
        	return island.stream().mapToInt(i->i).toArray();
        }
        return answer;
    }
}