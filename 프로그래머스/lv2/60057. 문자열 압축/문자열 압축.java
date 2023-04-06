import java.util.*;
class Solution {
    public int solution(String s) {
    	/**
    	 * 문자열 압축
    	 * 
    	 * 
    	 * */
        int answer = s.length();
        
        for (int i = 1; i <= s.length()/2; i++) {
			String base = s.substring(0,i);
			int cnt = 1;
			String str = base;
			for (int j = i; j < s.length();j+=i) {
				int endIdx = Math.min(j+i, s.length());
				String tmp = s.substring(j,endIdx);
				if(tmp.equals(base))
				{
					cnt++;
				}else {
					if(cnt!=1) {
						str+=cnt;
					}
					str+=tmp;
					base = tmp;
					cnt = 1;
				}
			}
			if(cnt!=1) {
				str+=cnt;
			}
			answer = Math.min(answer, str.length());
		}
        return answer;
    }
}