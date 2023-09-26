import java.util.*;

public class Solution {
    public int solution(int n) {
        /**
         * 점프와 순간 이동
         * 가는 방법 : K칸 앞으로 점프(K만큼 건전지 소모), 현재까지 온 거리 x 2
         * 배열 형식으로 진행 시 메모리 초과 문제 발생
         * 바텀업 방식으로 문제 풀기
         * */
		int ans = 0;
        while(n!=0) {
        	if(n%2==0) {
        		n/=2;
        	}else {
        		ans++;
        		n--;
        	}
        }
        return ans;
    }
}