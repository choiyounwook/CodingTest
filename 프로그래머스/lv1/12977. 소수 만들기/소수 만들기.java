import java.util.*;
class Solution {
   static int[] arr;
	public static int solution(int[] nums) {
        /**
         * 배열에 있는 서로 다른 수 3 개를 골라서 소수 만들기
         * */
		arr= nums;
        return FuncDecimal(0, 0, 0);
    }
	public static int FuncDecimal(int cnt,int value, int flag) {
		/**
		 * cnt : 현재 몇 개의 수를 골랐는지
		 * value : 현재 수
		 * flag : 현재 배열 인덱스
		 * */
		if(cnt==3) {
			int end = (int)Math.sqrt(value);
			for (int i = 2; i <=end; i++) {
				if(value%i==0) return 0;
			}
			return 1;
		} 
		if(flag>=arr.length) return 0;
		return FuncDecimal(cnt, value,flag+1) + FuncDecimal(cnt+1, value+arr[flag],flag+1);
	}
}