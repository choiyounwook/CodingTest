class Solution {
    public int solution(int number, int limit, int power) {
       	// 약수 구할 때 for문을 통해 하나씩 구하며 시간초과 발생
		
        int answer = 0;
        for (int i = 1; i <= number; i++) {
        	int cnt = 0;
			for (int j = 1; j*j <=i; j++) {
				if(j*j==i) cnt++;
				else if(i%j==0)cnt+=2;
			}
			answer+=(cnt>limit?power:cnt);
		}
        return answer;
    }
}