import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        /**
		 * N^2 배열 자르기
		 * 1.n 행 n열 크기의 비어있는 2차원 배열을 만든다
		 * 2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
		 * 		1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
		 * 3.1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
		 * 4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
		 * */
        int[] answer = new int[(int) (right-left+1)];
        int flag = 0;
        for (long i = left; i <=right; i++) {
        	
        	int x = (int) (i/n+1);
        	int y = (int) (i%n+1);
        	int num = Math.max(x, y);
			answer[flag++]=num;
		}
        return answer;
    }
}