import java.util.*;
class Solution {
    static class Remainder{
		String name;
		int time;
		
		public Remainder(String name, int time) {
			
			this.name = name;
			this.time = time;
		}
	}
	
	static class NewPlan{
		String name;
		int start;
		int time;
		public NewPlan(String name, int start, int time) {
			this.name = name;
			this.start = start;
			this.time = time;
		}
	}
	
	public static String[] solution(String[][] plans) {
		/**
		 * 과제 진행하기
		 * - 과제는 시작하기로 한 시각이 되면 시작합니다.
		 * - 새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
		 * - 진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
		 *   - 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
		 * - 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
		 * 
		 * plans
		 *  - 0 : 이름
		 *  - 1 : 시작 시간
		 *  - 2 : 과제 마치는데 걸리는 시간
		 *  
		 *  우선순위 큐 : 새로운 과제
		 *  스택 : 멈춘 과제
		 * */
        List<String> answer = new ArrayList<>();
        Stack<Remainder> remainder = new Stack<>();
        
        PriorityQueue<NewPlan> planList = new PriorityQueue<>((o1, o2)->{
        	return o1.start - o2.start;
        });
        
        for (int i = 0; i < plans.length; i++) {
			String time = plans[i][1];
			int h = Integer.parseInt(time.substring(0, 2));
			int m = Integer.parseInt(time.substring(3, 5));
			int total = 60 * h + m;
			planList.add(new NewPlan(plans[i][0], total, Integer.parseInt(plans[i][2])));

		}
        
        // 초기 과제
        NewPlan p = planList.poll();
        String curName = p.name;
        int curStart = p.start;
        int curTime = p.time;
        
        while(answer.size()!=plans.length) {
        	
        	int tmp = curStart + curTime;
        	
        	// 새로운 과제와 현재 과제 비교
        	if(!planList.isEmpty()) {
        		NewPlan n = planList.peek();
        		
        		// 새 과제 투입
        		if(n.start<tmp) {
        			planList.poll();
        			int rTime = tmp - n.start;
        			remainder.add(new Remainder(curName, rTime));
        			curName = n.name;
        			curStart = n.start;
        			curTime = n.time;
        			continue;
        		}
        	}
        	
        	// 과제 끝
        	answer.add(curName);
        	
        	// 새 과제 시작 시간과 끝난 시간이 같다면
        	if(!planList.isEmpty()) {
        		NewPlan n = planList.peek();
        		if(n.start==tmp) {
        			planList.poll();
        			curName = n.name;
        			curStart = n.start;
        			curTime = n.time;
        			continue;
        		}
        	}
        	
        	// 남아있는 과제
        	if(!remainder.isEmpty()) {
        		Remainder n = remainder.pop();
        		curName = n.name;
        		curStart = tmp;
        		curTime = n.time;
        		continue;
        	}
        	// 남아있는 과제가 없으면 새 과제 시작
        	if(!planList.isEmpty()) {
        		NewPlan n = planList.poll();
        		curName = n.name;
    			curStart = n.start;
    			curTime = n.time;
        	}
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}