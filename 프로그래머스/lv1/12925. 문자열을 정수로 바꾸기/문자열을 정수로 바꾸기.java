class Solution {
    public int solution(String s) {
       int answer = 1;
        if(s.charAt(0)=='-') {
        	answer=-1;
        	s = s.substring(1, s.length());
        }
        answer*=Integer.parseInt(s);
        return answer;
    }
}