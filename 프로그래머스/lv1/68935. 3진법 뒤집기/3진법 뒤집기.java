class Solution {
    public int solution(int n) {
        long answer = 0;
        int result=0;
        long flag=0;
        
        while(n!=0) {
        answer*=10;
        answer+=(n%3);
        n=n/3;
        }
        while(answer!=0)
        {
        	result+=(Math.pow(3,flag)*(answer%10));
        	flag++;
        	answer/=10;
        }
        return result;
    }
}