import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        /**
		 *  --정확성과 효율성 테스트--
		 * 
		 * 반드시 있어야 하는 항목 4 가지
		 * 코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
		 * 지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
		 * 지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
		 * 선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
		 * 
		 * -> hashMap + 이분 탐색
		 * */
        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
			String[] str = info[i].split(" ");
			String[] lang = {str[0],"-"};
			String[] skill = {str[1],"-"};
			String[] level = {str[2],"-"};
			String[] food = {str[3],"-"};
			Integer value = Integer.parseInt(str[4]);
			
			// hashmap 생성
			for (int i1 = 0; i1 < lang.length; i1++) {
				for (int i2 = 0; i2 < skill.length; i2++) {
					for (int i3 = 0; i3 < level.length; i3++) {
						for (int i4 = 0; i4 < food.length; i4++) {
							String[] tmp = {lang[i1],skill[i2],level[i3],food[i4]};
							String key = String.join(" ", tmp);
							ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
							list.add(value);
							map.put(key, list);
						}
					}
				}
			}
		}
        
        // map을 오름차순으로 정렬
        for (ArrayList<Integer> list : map.values()) {
			list.sort(null);
		}
        
        
        for (int i = 0; i < query.length; i++) {
        	String[] str = query[i].split(" ");
        	String key = str[0]+" "+str[2]+" "+str[4]+" "+str[6];
        	Integer value = Integer.parseInt(str[7]);
        	ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
        	int right= list.size();
        	int left = 0;
        	while(left<right) {
        		int mid = (left+right)/2;
        		if(list.get(mid)<value)
        		{
        			left=mid+1;
        		}else {
        			right=mid;
        		}
        	}
        	answer[i] = list.size()-left;
        	
		}
        
        return answer;
    }
}