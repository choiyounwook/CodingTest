class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]>='A'&&arr[i]<='Z')
			{
				arr[i]+=n;
				if(arr[i]>'Z') arr[i]-=26;
			}else if(arr[i]>='a'&&arr[i]<='z'){
				arr[i]+=n;
				if(arr[i]>'z') arr[i]-=26;
			}
			answer+=arr[i];
		}
        return answer;
    }
}