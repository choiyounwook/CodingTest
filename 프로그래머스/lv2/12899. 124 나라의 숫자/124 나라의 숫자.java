class Solution {
    public String solution(int n) {
        /**
		  * 124 나라의 숫자
		  * 자연수만 존재
		  * 1, 2, 4만 사용
		  * */
		 StringBuilder answer = new StringBuilder();
	        while(n>0)
	        {
	        	int tmp = n%3;
	        	n/=3;
	        	if(tmp==0) {
	        		answer.insert(0,4);
	        		n-=1;
	        	}
	        	else {
	        		answer.insert(0,tmp);
				}
	        }
	        return answer.toString();
    }
}