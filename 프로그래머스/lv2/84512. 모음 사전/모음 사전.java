import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        String [] strArr = {"A", "E", "I", "O", "U"};
        int flag = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 5; i++) {
        	String str1 = strArr[i];
        	map.put(str1, flag++);
			for (int j = 0; j < 5; j++) {
				String str2 = str1+strArr[j];
				map.put(str2, flag++);
				for (int j2 = 0; j2 < 5; j2++) {
					String str3 = str2+strArr[j2];
					map.put(str3, flag++);
					for (int k = 0; k < 5; k++) {
						String str4 = str3+strArr[k];
						map.put(str4, flag++);
						for (int k2 = 0; k2 < 5; k2++) {
							String str5 = str4+strArr[k2];
							map.put(str5, flag++);
						}
					}
				}
			}
		}
        return map.get(word);
    }
}