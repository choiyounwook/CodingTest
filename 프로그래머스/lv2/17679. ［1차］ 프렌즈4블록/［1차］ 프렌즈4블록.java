class Solution {
    public int solution(int m, int n, String[] board) {

		/**
		 * 프렌즈 4블록
		 * 
		 * 라이언 R
		 * 무지 M
		 * 어피치 A
		 * 프로도 F
		 * 네오 N
		 * 튜브 T
		 * 제이지 J
		 * 콘 C
		 * 
		 * 지워지는 블록의 갯수는?
		 * */
        int answer = 0;
        boolean checkRun = true;
        char[][] map = new char[m][n];
        int[] dirx = {0,0,1,1};
        int[] diry = {0,1,0,1};
        
        for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}
        
        while(checkRun)
        {

        	checkRun = false;
        	// 없앨 블록 체크
        	boolean[][] checkMap = new boolean[m][n];
        	for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					
					if(map[i][j]!='.'&&
							map[i][j]==map[i+1][j]&&
									map[i][j]==map[i][j+1]&&
											map[i][j]==map[i+1][j+1])
					{
						checkRun = true;
						for (int d = 0; d < dirx.length; d++) {
							if(!checkMap[i+dirx[d]][j+diry[d]])
							{
								answer++;
								checkMap[i+dirx[d]][j+diry[d]] = true;
							}
						}
					}
				}
				
			}
        	// 없앨 블록 삭제
        	for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(checkMap[i][j]) { 
						map[i][j] ='.';}
				}
			}
        	
        	// 블록 내리기
        	for (int i = m-1; i >= 0; i--) {
				for (int j = n-1; j >= 0; j--) {
					if(map[i][j]!='.') continue;
					int k = i;
					while(k > 0 && map[k][j]=='.') {
						k--;
					}
					
					if(map[k][j]=='.') continue;

					map[i][j] = map[k][j];
					map[k][j] = '.';
				}
			}
        	
        	
        }
        return answer;
    }
}