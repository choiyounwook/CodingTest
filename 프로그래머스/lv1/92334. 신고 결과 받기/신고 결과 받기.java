import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
         int num = id_list.length;
        boolean[][] id_map = new boolean[num][num];
        int[] check = new int[num];
        HashMap<String, Integer> ids = new HashMap<String, Integer>();
        int[] answer = new int[num];
        
        for (int i = 0; i < num; i++) {
        	ids.put(id_list[i], i);
        	check[i]=0;
        	answer[i]=0;
			for (int j = 0; j < num; j++) {
				id_map[i][j] = false;
			}
		}
        
        for (int i = 0; i < report.length; i++) {
			String[] str = report[i].split(" ");
			int id1 = ids.get(str[0]);
			int id2 = ids.get(str[1]);
			if(!id_map[id1][id2])
			{
				id_map[id1][id2] = true;
				check[id2]++;
			}
		}
        for (int i = 0; i < check.length; i++) {
			if(k<=check[i])
			{
				for (int j = 0; j < check.length; j++) {
					if(id_map[j][i])
					{
						answer[j]++;
					}
				}
			}
		}

        return answer;
    }
}