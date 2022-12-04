class Solution {
    public int solution(String[] babbling) {
       // "aya", "ye", "woo", "ma" 발음만 말할 수 있음. -> 네가지 조합으로만 된 발음 가능
		// 연속해서 같은 발음은 못함
        int answer = 0;
        for(String str : babbling) {
        	int check = 0;
        	for (int i = 0; i < str.length();i++) {
				if((i+3)<=str.length()&&str.substring(i, i+3).equals("aya")&&check!=1)
				{
					check = 1;
					i+=2;
				}else if((i+2)<=str.length()&&str.substring(i, i+2).equals("ye")&&check!=2)
				{
					check = 2;
					i+=1;
				}else if((i+3)<=str.length()&&str.substring(i, i+3).equals("woo")&&check!=3)
				{
					check = 3;
					i+=2;
				}else if((i+2)<=str.length()&&str.substring(i, i+2).equals("ma")&&check!=4)
				{
					check = 4;
					i+=1;
				}else {
					check = 0;
					break;
				}
			}
        	if(check!=0) answer++;
        }
        return answer;
    }
}