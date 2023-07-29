import java.util.*;
class Solution {
    public int[] solution(String msg) {
/**
		 * 압축
		 * 
		 * 시뮬레이션
		 * */
        
        Map<String, Integer> lzw = new HashMap<String, Integer>();
        int cnt =1;
        for (Character i = 'A'; i <='Z'; i++) {
			lzw.put(i+"", cnt++);
		}
        List<Integer> list = new ArrayList<Integer>();
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        // 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        // 3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
        // 4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
        // 5. 단계 2로 돌아간다.
        int max = msg.length();
        for (int i = 0; i < max;i++) {
			String w = msg.charAt(i) + "";
			for (int j = i+1; j < max; j++) {
				String c = w+msg.charAt(j);
				int value = lzw.getOrDefault(c, 0);
				if(value == 0) {
					lzw.put(c, cnt++);
					break;
				}
				
				w = c;
				i = j;
			}
			list.add(lzw.get(w));
		}
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}