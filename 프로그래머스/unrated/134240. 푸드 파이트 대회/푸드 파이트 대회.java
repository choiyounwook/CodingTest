class Solution {
    public String solution(int[] food) {
       String answer = "";
        String str1="";
        String str2="";
        
        // 0 번째 인덱스는 물을 의미하므로 생략
        for (int i = 1; i < food.length; i++) {
        	int cnt = food[i]/2;
        	for (int j = 0; j < cnt; j++) {
				str1=str1+i;
				str2=i+str2;
			}
		}
        answer=str1+"0"+str2;
        return answer;
    }
}