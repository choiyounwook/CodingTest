class Solution {
    public int solution(String s) {
        int answer = 0;
        int cntT=0;
        int cntF=0;
        char x='0';
        // x 같은 수 = x와 다른 수 일때 분리
        // 이때 x도 포함해서 카운팅을 한다.
        for(char c:s.toCharArray())
        {
            if(x=='0'){
                answer++;
                x=c;
            }
            if(x==c) cntT++;
            else cntF++;
            
            if(cntT==cntF)
            {
                cntT = cntF =0;
                x ='0';
            }
        }
        return answer;
    }
}