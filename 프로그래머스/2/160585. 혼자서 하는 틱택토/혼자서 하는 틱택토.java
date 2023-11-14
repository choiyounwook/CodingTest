class Solution {
    public static int solution(String[] board) {
		/**
		 * 혼자서 하는 틱택토
		 * java lv2
		 *  O이 선공 X가 후공
		 * 
		 * */
        int answer = 1;
        

        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if(board[i].charAt(j)=='O') cntO++;
				else if(board[i].charAt(j)=='X') cntX++;
			}
		}
        // 0이 나오는 경우 - X가 더 많은 경우
        if(cntX>cntO) return 0;
        
        // 0이 나오는 경우 - O가 X보다 2개 이상 많은 경우
        if(cntO>cntX+1) return 0;
        
        // 0이 나오는 경우 - O가 완성됐는데, X가 O의 개수랑 같은 경우
        if(checkWin(board, 'O')&&cntO==cntX) return 0;
        
        // 0이 나오는 경우 - X가 완성됐는데, O가 개수가 더 많은 경우
        if(checkWin(board, 'X')&&cntO>cntX) return 0;
        
        return answer;
    }
	
	public static boolean checkWin(String[] board, char ch) {
		
		// 가로
		for (int i = 0; i < board.length; i++) {
			boolean check = true;
			for (int j = 0; j < 3; j++) {
				if(board[i].charAt(j)!=ch) {
					check = false;
					break;
				}
			}
			if(check) return true;
		}
		
		// 세로
		for (int i = 0; i < board.length; i++) {
			boolean check = true;
			for (int j = 0; j < 3; j++) {
				if(board[j].charAt(i)!=ch) {
					check = false;
					break;
				}
			}
			if(check) return true;
		}
		
		// 대각선
		if(board[0].charAt(0)==ch&&board[1].charAt(1)==ch&&board[2].charAt(2)==ch) return true;
		if(board[0].charAt(2)==ch&&board[1].charAt(1)==ch&&board[2].charAt(0)==ch) return true;
		return false;
	}
}