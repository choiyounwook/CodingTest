import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
		/**
		 * today : 오늘 날짜
		 * terms : 약관 종류 및 약관별 보관 기간
		 * privacies : 수집된 개인정보의 정보
		 * 
		 * return 파기해야 하는 개인정보의 번호를 오름차순으로 정렬
		 * */

        HashMap<String,Integer> termList = new HashMap<String, Integer>();
        List<Integer> answerList = new ArrayList<>();
        
        // today를 날짜로 구하기
        String[] todayArr = today.split("\\.");
        int totalToday = (Integer.parseInt(todayArr[0])*12*28)+(Integer.parseInt(todayArr[1])*28)+Integer.parseInt(todayArr[2]);

        //약관 종류 및 약관별 보관 기간 정의
        for (int i = 0; i < terms.length; i++) {
			String[] str = terms[i].split(" ");
			termList.put(str[0], Integer.parseInt(str[1]));
		}
        
        //수집된 개인정보의 정보 중 파기할 정보 찾기
        for (int i = 0; i < privacies.length; i++) {
        	String[] str = privacies[i].split(" "); // 0은 날짜 1은 약관 종류
        	String[] cur = str[0].split("\\.");
        	int totalcur = (Integer.parseInt(cur[0])*12*28)+(Integer.parseInt(cur[1])*28)+Integer.parseInt(cur[2]);
        	totalcur+=(termList.get(str[1])*28);
        	if(totalToday>=totalcur) answerList.add(i);
		}
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
			answer[i]= answerList.get(i)+1;
		}
        return answer;
    }
}