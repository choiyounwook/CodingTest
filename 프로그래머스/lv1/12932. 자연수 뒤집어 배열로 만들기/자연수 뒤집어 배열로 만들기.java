class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(n+"").length()];
        int flag=0;
        while(n!=0) {
        	answer[flag++]=(int) (n%10);
        	n/=10;
        }
        return answer;
    }
}