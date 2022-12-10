import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
        	int totalUsers=0;
        	int falseUsers=0;
			for (int j = 0; j < stages.length; j++) {
				totalUsers+=(stages[j]>=i?1:0);
				falseUsers+=(stages[j]==i?1:0);
			}
			if(totalUsers==0) map.put(i, (double) 0);
			else map.put(i, (double) ((double)falseUsers/totalUsers));
			
		}
        List<Integer> maplist = new ArrayList<Integer>(map.keySet());
        maplist.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return map.get(o2).compareTo(map.get(o1));
			}
        	
		});
        for (int i = 0; i < answer.length; i++) {
			answer[i]=maplist.get(i);
		}
        return answer;
    }
}