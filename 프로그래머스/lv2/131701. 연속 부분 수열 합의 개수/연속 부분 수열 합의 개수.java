import java.util.*;
class Solution {
    public int solution(int[] elements) {
        /**
		 * 연속 부분 수열 합의 개수
		 * 
		 * */
        int answer = 0;
        HashSet<Integer> number = new HashSet<Integer>();
       for (int cnt = 1; cnt <= elements.length; cnt++) {
    	   for (int i = 0; i < elements.length; i++) {
    		   int num = 0;
    		   int cur=cnt;
    		   while(cur!=0)
    		   {
    			   num += elements[(i+cur-1)%elements.length];
    			   cur--;
    		   }
    		   number.add(num);
    	   }
       }
        
        return number.size();
    }
}