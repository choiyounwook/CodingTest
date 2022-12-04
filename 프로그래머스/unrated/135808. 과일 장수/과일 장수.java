import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
         int answer = 0;
        Integer[] arr= Arrays.stream(score).boxed().toArray(Integer[]::new);
        		
        // score 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        // m개의 사과 상자 만들기
        // 마지막 숫자가 가장 작은 숫자
        for(int i=m;i<=arr.length;i+=m)
        {
        	answer+=(arr[i-1]*m);
        }
      
        return answer;
    }
}