import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 =0;
        long sum2 =0;
        long total = 0;
        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();
        // 두 수가 같아질 수 있는 지 확인 - 아니라면 -1 반환
        for(int num: queue1) {
        	q1.add(num);
        	sum1+=num;
        }
        for(int num: queue2) {
        	q2.add(num);
        	sum2+=num;
        }
        total= sum1+sum2;
        if(total%2==1) return -1;
        int len = q1.size()+q2.size();
        while(sum1 !=sum2)
        {
        	if(answer>len*2)return -1;
        	if(sum1<sum2)
        	{
        		int tmp = q2.poll();
        		sum1+=tmp;
        		sum2-=tmp;
        		q1.add(tmp);
        	}else
        	{
        		int tmp = q1.poll();
        		sum2+=tmp;
        		sum1-=tmp;
        		q2.add(tmp);
        	}
        	answer++;
        }
        return answer;
    }
}