import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        // list에 score의 수 모두 삽입 후 절렬
        for(int i=0;i<score.length;i++) list.add(score[i]);
        list.sort(Collections.reverseOrder());
       // m개의 사과 상자 만들기
        // 마지막 숫자가 가장 작은 숫자
        for(int i = m;i<=list.size();i+=m) {
        	answer +=(list.get(i-1)*m);
        }

        return answer;
    }
}