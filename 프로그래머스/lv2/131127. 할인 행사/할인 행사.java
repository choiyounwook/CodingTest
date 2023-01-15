import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        /**
         * want : 원하는 제품
         * number : 원하는 제품의 수량
         * discount : XYZ 카트에서 할인하는 제품
         * 결과값 : 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
         * */
		
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}
		
		for (int i = 0; i <= (discount.length-10); i++) {
			HashMap<String, Integer> tmp = new HashMap<>();
			for (int k = 0; k < want.length; k++) {
				tmp.put(want[k], number[k]);
			}
			boolean flag = true;
			for (int j = i; j <i+10; j++) {
				if(tmp.getOrDefault(discount[j], 0)==0) {
					flag=false;
					break;
				}else {
					tmp.put(discount[j], tmp.getOrDefault(discount[j], 0)-1);
				}
			}
			if(flag) {answer++;}
		}
        return answer;
    }
}