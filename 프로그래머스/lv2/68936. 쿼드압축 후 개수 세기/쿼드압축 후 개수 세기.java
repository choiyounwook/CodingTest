class Solution {
	static int[][] map;
	static int[] answer;
	public static int[] solution(int[][] arr) {
        answer = new int[2];
        map=arr;
		backtracking(0,0,map.length);
        return answer;
    }
	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(map[x][y]!=map[i][j]) return false;
			}
		}

		return true;
	}
	
	public static void backtracking(int x, int y, int size) {
		if(check(x, y, size))
		{
			answer[map[x][y]]++;
			return;
		}
		backtracking(x+size/2,y,size/2);
		backtracking(x,y,size/2);
		backtracking(x,y+size/2,size/2);
		backtracking(x+size/2,y+size/2,size/2);
	}
}