class Solution {
   static int totalpluse=0;
	static int totalmoney=0;
	
	public static int[] solution(int[][] users, int[] emoticons) {
       
		/**
		 * 우선 순위
		 * 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
		 * 2. 이모티콘 판매액을 최대한 늘리는 것.
		 * */
		int[] answer = new int[2];
		dfs(new int[emoticons.length],emoticons,0,users);
		answer[0]=totalpluse;
		answer[1]=totalmoney;
        return answer;
    }
	public static void dfs(int[] saleemo, int[] emoticons, int flag,int[][] users) {
		if(flag==emoticons.length)
		{// 계산하기
			int tmpplus=0;
			int tmpmoney=0;
			for (int i = 0; i < users.length; i++) {
				int money=0;
				int discount = users[i][0];
				int price= users[i][1];
				for (int j = 0; j < emoticons.length; j++) {
					if(saleemo[j]>=discount)
						money+=((emoticons[j]/100)*(100-saleemo[j]));
				}
				if(money>=price) tmpplus++;
				else tmpmoney+=money;
			}
			if(tmpplus>totalpluse||(tmpplus==totalpluse&&tmpmoney>totalmoney))
			{
				totalpluse=tmpplus;
				totalmoney=tmpmoney;
			}
			return;
		}
		for (int i = 10; i <=40; i+=10) {
			saleemo[flag]=i;
			dfs(saleemo,emoticons,flag+1,users);
		}
	}
}