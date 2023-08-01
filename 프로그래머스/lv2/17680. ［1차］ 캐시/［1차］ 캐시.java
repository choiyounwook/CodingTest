import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        /** 
		 * 캐시
		 * 
		 * cacheSize : 캐시 크기
		 * cities : 도시 이름
		 * 
		 * 캐시 교체 알고리즘은 LRU 사용
		 * cache hit일 경우 실행 시간 : 1
		 * cache miss일 경우 실행 시간 : 5
		 * */
        int answer = 0;
        
        List<String> cacheList = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toLowerCase();
        	if(cacheList.remove(city))
        	{
        		// 캐시에 있는 경우
        		cacheList.add(city);
        		answer+=1;
        		
        	}else {
        		// 캐시에 없는 경우
        		cacheList.add(city);
        		answer+=5;
        		if(cacheList.size()>cacheSize) cacheList.remove(0);
        	}
		}
        return answer;
    }
}