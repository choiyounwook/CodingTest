class Solution {
    public int solution(int angle) {
        /**
		 * 각도기
		 * 0~89 : 예각 1
		 * 90 : 직각 2
		 * 91~179 : 둔각 3
		 * 180 평각 4
		 * */
        int answer = 0;
        if(angle<90) return 1;
        else if(angle==90) return 2;
        else if(angle>90&& angle<180) return 3;
       
        return 4;
    }
}