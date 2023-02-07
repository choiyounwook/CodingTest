import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        		
		/**
		 * 호텔 대실
		 * 0 번째 인덱스 : 대실 시작 시간
		 * 1 번째 인덱스 : 대실 종료 시각
		 * 표기 방법 00:00 ~ 23:00
		 * 퇴실 시간 후 10 분간 첨소 시간 필요
		 * 
		 * 최소 객실의 수
		 * */
		
		List<Integer> roomTime = new ArrayList<>();
        
		// 고객 대실 시간 정렬
		Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				if(o1[0].toString().contentEquals(o2[0])) return o1[1].toString().compareTo(o2[1]);
				else return o1[0].toString().compareTo(o2[0]);
			}
		});
		
		for (int i = 0; i < book_time.length; i++) {
			String[] startTimeArr = book_time[i][0].split(":");
			String[] endTimeArr = book_time[i][1].split(":");
			int startTime = 60*Integer.parseInt(startTimeArr[0])+Integer.parseInt(startTimeArr[1]);
			int endTime = 60*Integer.parseInt(endTimeArr[0])+Integer.parseInt(endTimeArr[1])+10;
			boolean flag = true;
			for (int j = 0; j < roomTime.size(); j++) {
				if(roomTime.get(j)<=startTime) {
					flag=false;
					roomTime.set(j, endTime);
					break;
				}
			}
			if(flag)roomTime.add(endTime);
		}
        return roomTime.size();
    }
}