class Solution {
    public String solution(String s) {
        String[] strArr = s.split("");
        String answer = "";
        int idx =0;
        for (int i = 0; i < strArr.length; i++) {
			if(strArr[i].equals(" "))
			{// 공백이면 다른 단어가 나오기 때문에 idx 초기화
				idx=0;
			}else if(idx%2==0)
			{
				// 짝수는 대문자
				strArr[i] = strArr[i].toUpperCase();
				idx++;
			}else {
				// 홀수는 소문자
				strArr[i] = strArr[i].toLowerCase();
				idx++;
			}
			answer+=strArr[i];
		}
        return answer;
    }
}