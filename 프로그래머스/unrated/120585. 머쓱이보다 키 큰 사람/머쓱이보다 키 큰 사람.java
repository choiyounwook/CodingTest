class Solution {
    public int solution(int[] array, int height) {
        /**
		 * 머쓱이보다 키 큰 사람
		 * 
		 * */
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
			if(height<array[i]) answer++;
		}
        return answer;
    }
}