import java.util.*;
class Solution {
    static class Mineral implements Comparable<Mineral>{
		int diamond;
		int iron;
		int stone;
		public Mineral() {
			diamond = 0;
			iron = 0;
			stone = 0;
		}
		
		@Override
		public int compareTo(Mineral o) {
			if(this.diamond > o.diamond) return -1;
			else if(this.diamond == o.diamond)
			{
				if(this.iron > o.iron) return -1;
				else if(this.iron == o.iron)
				{
					if(this.stone > o.stone) return -1;
					else return 1;
				}else return 1;
			}else return 1;
		}
	}
	
	public static int solution(int[] picks, String[] minerals) {
		/**
		 * 광물 캐기
		 * 
		 * picks : 곡괭이의 개수(다이아, 철, 돌)
		 * minerals : 광물들의 순서
		 * 
		 * 각 곡갱이는 종류에 상관없이 광물 5개를 캔 뒤에 사용할 수 없다
		 * 광물 캐기에 필요한 최소 피로도는?
		 * 
		 * 한번에 5개씩 광물을 순서대로 캘수 있기 때문에 5개씩 광물을 나눠 각 그룹의 다이아, 철, 스톤의 개수별로 정렬한다.
		 * 정렬 후 가장 단단한 광물이 많은 순으로 정렬한다.
		 * 단단한 광물이 많은 그룹은 단단한 곡괭이로 작업.
		 * */
        int answer = 0;
        int size =  minerals.length/5 + (minerals.length%5!=0 ? 1 : 0);
        int pSize = picks[0]+picks[1]+picks[2];
        List<Mineral> list = new ArrayList<Mineral>();
        for (int i = 0; i < size && i < pSize; i++) {
			Mineral m = new Mineral();
			int start = i*5;
			int end = i*5+5;
			for (int j = start; j < end; j++) {
				if(minerals.length<=j) break;
				if(minerals[j].equals("diamond"))
				{
					m.diamond++;
				}else if(minerals[j].equals("iron"))
				{
					m.iron++;
				}else if(minerals[j].equals("stone"))
				{
					m.stone++;
				}
			}
			list.add(m);

		}
        Collections.sort(list);
        int cnt = 0;
       
        // 다이아
        for (int i = 0; i < picks[0]; i++) {
        	Mineral m = list.get(cnt++);
        	answer +=m.diamond*1 + m.iron*1 + m.stone*1;
        	if(cnt>=list.size()) return answer;
		}
        
        // 철
        for (int i = 0; i < picks[1]; i++) {
        	Mineral m = list.get(cnt++);
        	answer += m.diamond*5 + m.iron*1 + m.stone*1;
        	if(cnt>=list.size()) return answer;
		}
        // 돌
        for (int i = 0; i < picks[2]; i++) {
        	Mineral m = list.get(cnt++);
        	answer += m.diamond*25 + m.iron*5 + m.stone*1;
        	if(cnt>=list.size()) return answer;
		}
        return answer;
    }
}