import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        /**
		 * 프로그래머스 H-index
		 * 
		 * n : 발표한 논문의 수 h : h 번 이상 인용된 논문이 h편 이상이고 나머지 논문은 h 번 이하 인용된 것 정렬 사용 시
		 */

		int answer = 0;
		int n = citations.length; // 논문 수

		Arrays.sort(citations);

		for (int h = n; h > 0; h--) {

			// h번 이하 인용
			int min = 0;
			for (int i = 0; i < n; i++) {
				if (citations[i] < h) {
					min++;
				} else
					break;
			}
			
			// h번 이상 논문 인용
			int max = n - min;
			if (h <= max && h >= min) {
				answer = h;
				break;
			}
		}
		return answer;
    }
}