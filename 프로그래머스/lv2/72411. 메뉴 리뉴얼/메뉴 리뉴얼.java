import java.util.*;
class Solution {
	static  Map<String, Integer> map = new HashMap<>();
	static int[] ans;
	public static String[] solution(String[] orders, int[] course) {
		/**
		 * 메뉴 리뉴얼
		 * 
		 * orders에 있는 메뉴 중에서 course 개 만큼 뽑은 코스 요리 중 가장 많은 것들을 모아서 return
		 * */
		int lastIndex =course.length-1;
       ans=new int[course[lastIndex]+1];
       
        for (int i = 0; i < orders.length; i++) {
			String order = orders[i];
			char[] chars = order.toCharArray();
			Arrays.sort(chars);
			order=new String(chars);
			for (int j = 0; j < course.length; j++) {
				bfs(order,"",0,course[j]);
			}
		}
        
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries,(o1,o2)->o1.getKey().compareTo(o2.getKey()));
        LinkedList<String> list = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : entries) {
        	if(entry.getValue()>=2&&entry.getValue()>=ans[entry.getKey().length()]) list.add(entry.getKey());
        }
        
        return list.stream().toArray(String[]::new);
    }
	
	public static void bfs(String str,String course, int index, int end) {
		if(course.length()>=end) {

			map.put(course, map.getOrDefault(course, 0)+1);
			ans[end] = Math.max(ans[end], map.get(course));
			return;
		}
		for (int i = index; i < str.length(); i++) {
			bfs(str, course+str.charAt(i), i+1, end);
		}
	}
}