class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[(arr.length!=1?arr.length-1:1)];
        if(arr.length==1) {
        	answer[0] = -1;
        	return answer;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
        	min = Math.min(min, arr[i]);
		}
        for (int i = 0, j=0; i < answer.length; i++,j++) {
			if(arr[j]==min) {
				j++;
			}
			answer[i]=arr[j];
		}
        return answer;
    }
}