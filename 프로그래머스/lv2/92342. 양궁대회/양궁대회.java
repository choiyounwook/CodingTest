class Solution {
static int max = -1;
	static int[] answer = {-1};
	static int[] lionInfo;
	public static void dfs(int n, int[] apeachInfo) {
		if(n==0)
		{// 계산
			int apeachScore=0; 
			int lionScore=0;
			// 선수들의 점수 계산
			for (int i = 0; i <=10; i++) {
				if(!(apeachInfo[i]==0&&lionInfo[i]==0))
				{
					if(apeachInfo[i]>=lionInfo[i])
					{
						apeachScore+=10-i;
					}else if(apeachInfo[i]<lionInfo[i]) {
						lionScore+=10-i;
					}
				}

			}
			// 승자 정하기
			int num = lionScore-apeachScore;
			if(lionScore>apeachScore&&num>=max)
			{
				max = num;
				answer = lionInfo.clone();
				
			}
			return;
		}
		// 0 ~ 10 점까지 계산
		// 시간 초과 방지를 위한 가지치기 필요
		for (int i = 0; i <=10&&lionInfo[i]<=apeachInfo[i]; i++) {
			lionInfo[i]++;
			dfs(n-1, apeachInfo);
			lionInfo[i]--;
			
		}
		
	}
	public static int[] solution(int n, int[] info) {
		/*
		 * 양궁 대회 룰
		 * 1. 어피치가 n 번 쏜 후 라이언이 n 번 쏜다
		 * 2. k점을 더 많이 맞춘 선수가 k점을 가져간다.(만약 같다면 어피치가 점수 가져감, 둘다 못 맞추면 0 점)
		 * 3. 최종 점수가 높은 사람이 우승자 - 만약 동점인 경우 어피치가 우승
		 * 
		 * 짤 코드
		 * 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를 10점부터 0점까지 순서대로 정수 배열에 담아 return 
		 * 비기거나 지면 -1 리턴
		 * 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return
		 * 
		 * 완전 탐색으로 모든 경우 찾기 + 가지치기
		 * */
		lionInfo = new int[11];
		dfs(n, info );

        return answer;
    }
}