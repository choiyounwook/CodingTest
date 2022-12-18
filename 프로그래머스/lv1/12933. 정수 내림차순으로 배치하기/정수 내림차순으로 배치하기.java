import java.util.*;
class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<Integer>();
		String answer = "";
		while(n!=0) {
			list.add((int) (n%10));
			n/=10;
		}
		list.sort(Collections.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			answer+=list.get(i);
		}
         return Long.parseLong(answer);
    }
}