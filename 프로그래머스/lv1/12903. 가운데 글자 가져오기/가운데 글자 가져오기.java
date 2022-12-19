class Solution {
    public String solution(String s) {
        String answer = "";
        System.out.println(s);
        int num = s.length()/2;
        if(s.length()%2==0) return s.charAt(num-1)+""+s.charAt(num);
        return s.charAt(num)+"";
    }
}