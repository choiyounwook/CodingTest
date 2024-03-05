import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       /**
		 * 프로그래머스 K번째수
		 * 
		 * i 번째 숫자 ~ j 번째 숫자 중 정렬했을 때 k 번째에 있는 숫자는?
		 * 
		 */
		int[] answer = new int[commands.length];

        
		for (int num = 0; num < commands.length; num++) {
			int i = commands[num][0];
			int j = commands[num][1];
			int k = commands[num][2];
			int[] arr = Arrays.copyOfRange(array, i - 1, j);
			Arrays.sort(arr);
			answer[num] = arr[k - 1];
		}
		return answer;
    }
}