import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       /*
         * commands[x][0] = i
         * commands[x][1] = j
         * commands[x][2] = k
         * array를 i~j까지 자르고 정렬 후 그 중 k 번째 수 찾기
         * */
		
		int[] answer = new int[commands.length];
		
		for (int command = 0; command < commands.length; command++) {
			int i = commands[command][0];
			int j = commands[command][1];
			int k = commands[command][2];
			
			List<Integer> list = new ArrayList<Integer>();
			for (int l = i; l <=j; l++) {
				list.add(array[l-1]);
			}
			Collections.sort(list);
			answer[command]=(list.get(k-1));
		}

        
        return answer;
    }
}