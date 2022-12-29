import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k>=enemy.length) return enemy.length;
	    Queue<Integer> pq = new PriorityQueue<>();
		int answer = -1;
		
		for (int i = 0; i < enemy.length; i++) {
			if(k>0)
			{
				pq.add(enemy[i]);
				k--;
				continue;
			}
			int tmp = pq.poll();
			int max = Math.max(tmp, enemy[i]);
			int min = Math.min(tmp, enemy[i]);
			pq.add(max);
			n-=min;
			if(n<0) return i;
		}
		
        return enemy.length;
    }
}