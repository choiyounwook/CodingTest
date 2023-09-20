import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        /**
		 * 영어 끝말잇기
		 * 
		 * 탈락하는 이유
		 * - 중복 단어
		 * - 끝말잇기 안 됨
		 * */
        int[] answer = {0,0};

        Set<String> wordSet = new HashSet<>();
        String str = words[0];
        wordSet.add(str);
        
        for (int i = 1; i < words.length; i++) {

        	if(!wordSet.contains(words[i])&&words[i].charAt(0)==str.charAt(str.length()-1)) {

        		str = words[i];
        		wordSet.add(str);
        	}else {
        		int member = (i%n)+1;
        		int time = (i/n)+1;
        		answer[0] = member;
        		answer[1] = time;
        		break;
        	}

		}

        return answer;
    }
}