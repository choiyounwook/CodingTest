class Solution
{
    public int solution(int n, int a, int b)
    {
/**
		 * 예상 대진표
		 * 
		 *  n : 게임 참가자 수
		 *  a : 참가자 번호
		 *  b : 경쟁자 번호
		 *  
		 *  a와 b는 서로 만나기 전까지 항상 이김
		 *  a와 b가 몇 번째 라운드에서 만나는지 구하기
		 * */
        int answer = 0;

        // a 가 무조건 b보다 더 작을 수 있도록 설정
        if(a>b)
        {
        	int tmp = a;
        	a = b;
        	b = tmp;
        }
        
        while(a!=b)
        {
        	a = (a%2==1?a/2+1:a/2);
        	b = (b%2==1?b/2+1:b/2);
        	answer++;
        }

        return answer;
    
    }
}