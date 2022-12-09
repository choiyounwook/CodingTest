import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
         String answer = "";
        HashMap<String, Integer> check = new HashMap<>();
        check.put("R", 0);
        check.put("T", 0);
        check.put("C", 0);
        check.put("F", 0);
        check.put("J", 0);
        check.put("M", 0);
        check.put("A", 0);
        check.put("N", 0);
        
        for (int i = 0; i < choices.length; i++) {
			int num = 4 - choices[i];
			if(num==0) continue;
			else if(num>0)
			{
				// 1~3
				check.put(survey[i].charAt(0)+"", check.get(survey[i].charAt(0)+"")+num);
			}else
			{
				// 5~7
				check.put(survey[i].charAt(1)+"", check.get(survey[i].charAt(1)+"")-num);
			}
		}
        // R이 T보다 사전순으로 앞이다.
        // T가 클때만 T가 될 수 있음
        if(check.get("R")<check.get("T")) answer+="T";
        else answer+="R";
        
        // C이 F보다 사전순으로 앞이다.
        // F가 클때만 F가 될 수 있음
        if(check.get("C")<check.get("F")) answer+="F";
        else answer+="C";
        
        // J이 M보다 사전순으로 앞이다.
        // M가 클때만 M가 될 수 있음
        if(check.get("J")<check.get("M")) answer+="M";
        else answer+="J";
        
        // A이 N보다 사전순으로 앞이다.
        // N가 클때만 N가 될 수 있음
        if(check.get("A")<check.get("N")) answer+="N";
        else answer+="A";
        return answer;
    }
}