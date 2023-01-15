class Solution {
    public int solution(int storey) {
        int answer = 0;
		
		while(storey!=0) {
			int n = storey%10;
			storey/=10;
			if(n>5)
			{
				// 6 이상일 경우
				answer+=(10-n);
				storey+=1;
				
			}else if(n<5) {
				// 4 이하인 경우
				answer+=n;
			}else {
				// 5인 경우 
				int next = storey%10;
				if(next>=5)
				{
					answer+=(10-n);
					storey+=1;
				}else {
					answer+=n;
				}
			}
		}
        return answer;
    }
}