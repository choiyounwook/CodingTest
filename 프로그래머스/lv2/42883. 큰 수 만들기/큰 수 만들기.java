class Solution {
    public static String solution(String number, int k) {
    	/**
    	 * 큰 수 만들기
    	 * 
    	 * 재귀 함수 사용 -> 런타임 +  메모리 초과 발생
    	 * 그리디 알고리즘 사용
    	 * */
    	StringBuilder ans = new StringBuilder();
		int start = 0;
		char[] num = number.toCharArray();
        for (int i = 0; i < number.length() - k; i++) {
			char max = '0';
			for (int j = start; j <=i+k; j++) {
				if(max < num[j]){
					max = num[j];
					start = j+1;
				}
			}
			ans.append(max);
		}
        return ans.toString();
    }
}