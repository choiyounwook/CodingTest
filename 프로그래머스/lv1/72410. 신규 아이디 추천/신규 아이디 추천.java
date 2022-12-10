class Solution {
    public String solution(String new_id) {
       /* 시뮬레이션
		 * 유저가 아이디 규칙에 맞지 않는 아이디를 입력했을 시 규칙과 맞는 유사한 아이디로 변경
		 * 아이디 길이 3~15
		 * 아이디 : 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표만 사용 가능(마침표는 처음과 끝에 사용 X, 연속 사용 X)*/
        String answer = "";
        
        // 1. 대문자를 모두 소문자로 변경
        new_id = new_id.toLowerCase();
        // 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자 제거
        int flag = 0;
        while(flag<new_id.length())
        {
        	char ch = new_id.charAt(flag);
        	if((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9')||ch=='-'||ch=='.'||ch=='_')
        	{
        		flag++;
        		continue;
        	}else {
        		new_id=new_id.replaceAll("\\"+ch, "");
        	}
        }
        // 3. 마침표가 연속 2 번 이상이면 하나의 마침표로 변경
        while(new_id.contains(".."))
        {
        	new_id=new_id.replace("..", ".");
        }
        // 4. 마침표가 처음이나 끝에 있으면 제거
        if(new_id.length()!=0)
        {
        	if(new_id.charAt(0)=='.') new_id=new_id.substring(1, new_id.length());
        }
        if(new_id.length()!=0)
        {
        	if(new_id.charAt(new_id.length()-1)=='.') new_id=new_id.substring(0, new_id.length()-1);
        }
        // 5. 빈문자열이라면 a 대입
        if(new_id.equals("")) new_id="a";
        // 6. 16 자 이상이면 첫 15개 문자 이후 문자는 제거 (제거 후 마침표가 마지막이면 제거)
        if(new_id.length()>15) {
        	new_id=new_id.substring(0, 15);
        	if(new_id.charAt(new_id.length()-1)=='.') new_id=new_id.substring(0, new_id.length()-1);
        }
        // 7. 길이가 2자 이하일 경우 마지막 문자를 계속 더함(3이 될떄까지)
        while(new_id.length()<3)
        {
        	new_id+=new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}