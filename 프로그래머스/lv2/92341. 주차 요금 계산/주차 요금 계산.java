import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
		/**
		 * 주차 요금 계산
		 * fees : 요금표
		 * 	fees[0] = 기본 시간(분)
		 * 	fees[1] = 기본 요금(원)
		 * 	fees[2] = 단위 시간(분)
		 * 	fees[3] = 단위 요금(원)
		 * records : 입/출차 기록
		 * 
		 * 출차 기록이 없는 경우 23:59에 출차된 것으로 간주
		 * 
		 * */
		// 차들이 주차한 시간
        HashMap<Integer, Integer> Cars = new HashMap<>();
        //입차 정보
        HashMap<Integer, Integer> record = new HashMap<>();
		
        // 각 차의 주차 시간 구하기
        for (int i = 0; i < records.length; i++) {
        	String[] carRecord = records[i].split(" ");
    		int carNumber = Integer.parseInt(carRecord[1]);
    		String[] catTime = carRecord[0].split(":");
    		int hour = Integer.parseInt(catTime[0]);
    		int minute = Integer.parseInt(catTime[1]);
    		int totalTime = hour*60+minute;
    		
        	if(carRecord[2].equals("IN")) {
        		record.put(carNumber, totalTime);
        	}else {
        		int inTime = record.getOrDefault(carNumber, 0);
        		Cars.put(carNumber, Cars.getOrDefault(carNumber, 0)+(totalTime-inTime));
        		record.remove(carNumber);
        	}
		}
        
        // 출차 안한 차들 처리
       for(Entry<Integer, Integer> entryCar : record.entrySet()) {
    	   int time = 1439 - entryCar.getValue();
    	   Cars.put(entryCar.getKey(), Cars.getOrDefault(entryCar.getKey(), 0)+time);
       }
        
        // 차번호 정렬
        Object[] mapNumber = Cars.keySet().toArray();
        Arrays.sort(mapNumber);
        
		int[] answer = new int[Cars.size()];
        // 주차 비용 구하기
        for (int i = 0; i < mapNumber.length; i++) {
			answer[i]=fees[1];
			int time = Cars.get(mapNumber[i])-fees[0];
			if(time<=0) continue;
			answer[i]+=(time/fees[2])*fees[3];
			answer[i]+=(time%fees[2]==0?0:fees[3]);
		}

        
        return answer;
    }
}