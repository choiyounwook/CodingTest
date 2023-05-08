class Solution {
    public int[] solution(int brown, int yellow) {
        /**
		 * 카펫
		 * brown와 yellow의 약수 구하기
		 * 가로가 세로보다 길거나 같아야 한다
		 * */
        int[] answer = {0,0};
        int total = brown+yellow; // 전체 격자의 수
        
        for (int i = total; i >0; i--) {
			
        	// 약수가 아닌 수라면 다음 차례로 넘어감
        	if(total%i!=0) continue;
        	int row = i;
        	int col = total/row;
        	
        	// 세로가 가로보다 길다면 다음 차례로 넘어감
        	if(col>row) continue;
        	
        	// yellow 수가 일치하는지 검사
        	int tmp = (row-2) *(col-2);
        	if(yellow==tmp)
        	{
        		answer[0]=row;
        		answer[1]=col;
        		return answer;
        	}
        	
		}
        
        return answer;
    }
}