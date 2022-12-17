class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        /**
         * 지도 : n*n
         * 공백(" ") 또는 벽("#")
         * arr1과 arr2는 각 지도의 벽을 나타냄 -> 1 벽, 0 빈공간
         * arr1과 arr2를 합쳐서 최종 지도를 출력하기
         * */
		String[] answer = new String[n];
        
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]);
			answer[i] = String.format("%16s", answer[i]);
			answer[i] = answer[i].substring(answer[i].length()-n);
			answer[i] = answer[i].replaceAll("1", "#");
			answer[i] = answer[i].replaceAll("0", " ");
		}
		
		
        return answer;
    }
}