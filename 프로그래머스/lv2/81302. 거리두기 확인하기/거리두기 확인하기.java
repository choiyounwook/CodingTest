class Solution {
    public int[] solution(String[][] places) {
	/**
		 * 거리두기 확인하기
		 * P : 응시자가 앉은 자리
		 * O : 빈 테이블
		 * X : 파티션
		 * 
		 * 대기실별로 거리두기를 지키고 있으면 1, 한명이라도 안 지키고 있으면 0을 배열에 담아서 리턴
		 * */
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
			String[] place = places[i];
			answer[i]=1;
			for (int x = 0; x < 5; x++) {
				boolean flag = false;
				for (int y = 0; y < 5; y++) {
					if(place[x].charAt(y)=='P') {
					 // 거리 1
						int[] mx1 = {0,-1,0,1};
						int[] my1 = {-1,0,1,0};
						for (int j = 0; j <4; j++) {
							int tmpx = mx1[j]+x;
							int tmpy = my1[j]+y;
							if(tmpx>=0&&tmpy>=0&&tmpx<5&&tmpy<5&&place[tmpx].charAt(tmpy)=='P')
							{
								flag=true;
								answer[i]=0;
								break;
							}
						}
						
					// 거리 2
						int[] mx2 = {0,-2,0,2};
						int[] my2 = {-2,0,2,0};
						for (int j = 0; j < 4; j++) {
							int tmpx = mx2[j]+x;
							int tmpy = my2[j]+y;
							if(tmpx>=0&&tmpy>=0&&tmpx<5&&tmpy<5&&place[tmpx].charAt(tmpy)=='P')
							{
								tmpx = mx1[j]+x;
								tmpy = my1[j]+y;
								if(place[tmpx].charAt(tmpy)!='X')
								{
									flag=true;
									answer[i]=0;
									break;
								}
							}
						}
						
					// 대각선
						int[] mx3 = {1,1,-1,-1};
						int[] my3 = {-1,1,-1,1};
						for (int j = 0; j < 4; j++) {
							int tmpx = mx3[j]+x;
							int tmpy = my3[j]+y;
							if(tmpx>=0&&tmpy>=0&&tmpx<5&&tmpy<5&&place[tmpx].charAt(tmpy)=='P')
							{
								if(place[x+mx3[j]].charAt(y)!='X'||place[x].charAt(y+my3[j])!='X')
								{
									flag=true;
									answer[i]=0;
									break;
								}
							}
						}
					}
					if(flag) break;
				}
				if(flag) break;
			}
		}
        return answer;
    }
}