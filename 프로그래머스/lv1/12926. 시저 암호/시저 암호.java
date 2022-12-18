class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]>='A'&&arr[i]<='Z')
			{
				arr[i]= (char) ((arr[i]-'A'+n)%26+'A');
			}else if(arr[i]>='a'&&arr[i]<='z'){
				arr[i]=(char) ((arr[i]-'a'+n)%26+'a');
			}
			answer+=arr[i];
		}
        return answer;
    }
}