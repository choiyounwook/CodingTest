class Solution {
    public String solution(int a, int b) {
       String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int[] month = {0,5,1,2,5,0,3,5,1,4,6,2,4};
        String answer = "";
        return week[(month[a]+b-1)%7];
    }
}