import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int flag = -1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
			if(flag!=arr[i]) {
				list.add(arr[i]);
				flag=arr[i];
			}
		}
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}