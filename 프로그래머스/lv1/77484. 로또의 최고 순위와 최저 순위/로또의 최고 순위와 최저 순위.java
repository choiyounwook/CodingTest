import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = new ArrayList<Integer>();
		int zero = 0;
		int total =0;
		for (int i = 0; i < win_nums.length; i++) {
			list.add(win_nums[i]);
		}
		for (int i = 0; i < lottos.length; i++) {
			if(lottos[i]==0) zero++;
			else if(list.contains(lottos[i])) total++;
		}
		int a = (zero+total)>1?7-(zero+total):6;
		int b = total>1?7-total:6;
        return new int[] {a,b};
    }
}