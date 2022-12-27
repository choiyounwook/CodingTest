import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
      /**
        * col 번째 컬럼의 값을 기준으로 오름차순 정렬, 값이 동일하면 컷 번째 컬럼을 기준으로 내임 차순
        * */
		Arrays.sort(data,(o1,o2)->{
			if(o1[col-1]==o2[col-1])
			{
				return Integer.compare(o2[0], o1[0]);
				
			}else return Integer.compare(o1[col-1], o2[col-1]);
		});
		/**
		 * ans = row_begin 번째 행의 튜플에 대하 각 컬럼의 값을 row_begin로 나눈 나머지의 합 ~ row_end 번째 행의 튜플에 대하 각 컬럼의 값을 row_begin로 나눈 나머지의 합의 XOR
		 * */
		int ans = 0;
		for (int i = row_begin; i <=row_end; i++) {
			int tmp = 0;
			for (int j = 0; j < data[i-1].length; j++) {
				tmp += (data[i-1][j]%i);
			}
			ans^=tmp;
		}
		
        return ans;
    }
}