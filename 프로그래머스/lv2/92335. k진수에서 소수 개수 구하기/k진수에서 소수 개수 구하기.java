import java.util.*;
class Solution {
    public int solution(int n, int k) {
    	/**
		 * n : 양의 정수
		 * k : 진수
		 * 
		 * n을 k진수로 변환 후 아래 조건에 맞는 소수의 개수 구하기
		 * 0P0처럼 소수 양쪽에 0이 있는 경우
		 * P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
		 * 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
		 * P처럼 소수 양쪽에 아무것도 없는 경우
		 * 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다. 예를 들어, 101은 P가 될 수 없습니다.
		 * */
        int answer = 0;
        String str =Integer.toString(n, k);

        String[] StrArr = str.split("0");
        for(String tmp:StrArr) {
        	if(tmp.equals("")) continue;
        	Long num = Long.parseLong(tmp);
        	if(isPrime(num)) answer++;
        }
        return answer;
    }
	
	public static boolean isPrime(Long n) {
		if(n < 2) return false;
		
		for (int i = 2; i <=Math.sqrt(n); i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	
}