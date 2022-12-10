class Solution {
    public String solution(int[] numbers, String hand) {
        /* 시뮬레이션
         * 1. 엄지손가락은 상하좌우로만 움직일 수 있다.
         * 2. 왼쪽 1,4,7
         * 3. 오른쪽 3,6,9
         * 4. 2,5,8,0은 두 손가락 중 가까운 손가락으로 누른다.(만약 같은 경우 왼손잡이는 왼손, 오른손잡이는 오른손)
         * */
		String answer = "";
		int Lhand = 10;
		int Rhand = 12;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]%3==1)
			{// 왼손
				answer+="L";
				Lhand=numbers[i];
			}else if(numbers[i]%3==0&&numbers[i]!=0)
			{//오른손
				answer+="R";
				Rhand=numbers[i];
			}else {
				if(numbers[i]==0)numbers[i]=11;
				int Lcnt =(Lhand%3==1?1:0)+Math.abs((Lhand-1)/3 - (numbers[i]-1)/3);
				int Rcnt=(Rhand%3==0?1:0)+Math.abs((Rhand-1)/3 - (numbers[i]-1)/3);
				
				if(Lcnt<Rcnt)
				{
					answer+="L";
					Lhand=numbers[i];
				}else if(Rcnt<Lcnt)
				{
					answer+="R";
					Rhand=numbers[i];
				}else
				{
					if(hand.equals("left"))
					{
						answer+="L";
						Lhand=numbers[i];
					}else {
						answer+="R";
						Rhand=numbers[i];
					}
				}
			}
		}
        return answer;
    }
}