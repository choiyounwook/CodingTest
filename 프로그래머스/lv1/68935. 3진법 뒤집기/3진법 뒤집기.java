class Solution {
    public int solution(int n) {
        int answer = 0;
        String result="";
        
        while(n!=0) {
        result+=(n%3);
        n=n/3;
        }
        return Integer.parseInt(result,3);
    }
}