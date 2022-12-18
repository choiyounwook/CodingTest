class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = s.length() - s.replace("p", "").length();
       p += s.length() - s.replace("P", "").length();
       int y= s.length() - s.replace("y", "").length();
       y += s.length() - s.replace("Y", "").length();

        return p==y?true:false;
    }
}