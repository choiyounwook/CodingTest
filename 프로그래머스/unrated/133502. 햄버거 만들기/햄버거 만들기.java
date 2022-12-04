import java.util.*;
class Solution {
 
    public int solution(int[] ingredient) {
       // 1 빵, 2 야채, 3 고기
		// 빵 야채 고기 빵 순으로 들어와야 햄버거 1 개 - 1231
		// burger.contains 으로 탐색 시 시간 초과 발생
		// list에 삽입과 동시에 1231가 있는지 검색 후 있으면 1231 삭제
        int answer = 0;
        List<Integer> burger = new ArrayList<Integer>();
        for (int i = 0; i < ingredient.length; i++) {
			burger.add(ingredient[i]);
			
			if(burger.size()>=4)
			{
				if(burger.get(burger.size()-4)==1&&
						burger.get(burger.size()-3)==2&&
						burger.get(burger.size()-2)==3&&
						burger.get(burger.size()-1)==1) {
					answer++;
					burger.remove(burger.size()-1);
					burger.remove(burger.size()-1);
					burger.remove(burger.size()-1);
					burger.remove(burger.size()-1);
				}
			}
		}
        return answer;
    }
}