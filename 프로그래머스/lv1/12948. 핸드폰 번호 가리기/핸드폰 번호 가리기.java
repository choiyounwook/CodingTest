class Solution {
    public String solution(String phone_number) {
        int num = phone_number.length();
		String answer =phone_number.substring(num-4,num);
        for (int i = 0; i < num-4; i++) {
			answer= "*"+answer;
		}
	return answer;
    }
}