import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
    	/**
    	 * 구명보트
    	 * 
    	 * 그리디 문제
    	 * 
    	 * 최대 2명까지 탈 수 있음
    	 * 
    	 * */
        int answer = 0;
        Integer[] sortedPeople = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedPeople, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
        	
		});

        int start = 0;
        int end = sortedPeople.length-1;
        while(start<=end) {
        	int sum = sortedPeople[start] + sortedPeople[end];
        	if(sum>limit)
        	{
        		start++;
        	}else {
        		start++;
        		end--;
        	}
        	answer++;
        }
        
        return answer;
    }
}