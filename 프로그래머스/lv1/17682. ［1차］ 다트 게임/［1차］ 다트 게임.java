import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] value = new int[3];
        int flag=-1;
        for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			
			// 숫자일 경우
			if(ch>='0'&&ch<='9')
			{
				flag++;
				String str = ch+"";
				if(ch=='1'&&i+1<dartResult.length()&&dartResult.charAt(i+1)=='0')
				{
					i++;
					str+=dartResult.charAt(i);
				}
				value[flag] = Integer.parseInt(str);
				
			}else if(ch=='D')
			{ // Double
				value[flag] = (int)Math.pow(value[flag], 2);
			}else if(ch=='T') {
				// Triple
				value[flag] = (int)Math.pow(value[flag], 3);
			}else if(ch=='*') {
				value[flag]*=2;
				if(flag!=0) value[flag-1]*=2;
			}else if(ch=='#') {
				value[flag]*=-1;
			}
		}
for (int i = 0; i < value.length; i++) {
			answer+=value[i];
		}
        return answer;
    }
}