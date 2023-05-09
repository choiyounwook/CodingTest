import java.util.*;
class Solution {
static Set<Integer> list = new HashSet<>();
	static boolean[] check;
	public static int solution(String numbers) {
		/*
		 * 소수 찾기
		 * 
		 * dfs(숫자 조합) + 소수 여부 확인
		 * **/
        int answer = 0;
        check = new boolean[numbers.length()];
        // 숫자 조합 찾기 + set을 사용해 중복 제거
        for (int i = 1; i <= numbers.length(); i++) {
			dfs(numbers, "", 0, i);
		}
        // 소수 여부 확인
        for(int item: list) {
        	if(isPrime(item)) answer++;
        }

        return answer;
    }
	
	public static void dfs(String origin, String num, int cur, int max) {
		
		if(cur==max)
		{
			list.add(Integer.parseInt(num));
		}else {
			for (int i = 0; i < origin.length(); i++) {
				if(check[i])continue;
				check[i] = true;
				dfs(origin, num+origin.charAt(i), cur+1, max);
				check[i] = false;
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num<2) return false;
		for (int i = 2; i*i <= num; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}