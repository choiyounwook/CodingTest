import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	Stack<Character> stack = new Stack<Character>();
        	boolean flag =true;
        	for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='{'||s.charAt(j)=='['||s.charAt(j)=='(')
				{
					stack.add(s.charAt(j));
				}else if(s.charAt(j)=='}'||s.charAt(j)==']'||s.charAt(j)==')') {
					if(s.charAt(j)=='}'&&!stack.isEmpty()&&stack.peek()=='{')
					{
						stack.pop();
					}else if(s.charAt(j)==']'&&!stack.isEmpty()&&stack.peek()=='[') {
						stack.pop();
					}else if(s.charAt(j)==')'&&!stack.isEmpty()&&stack.peek()=='(') {
						stack.pop();
					}else {
					flag=false;
					break;
					}
				}
			}
        	if(flag&&stack.isEmpty()) answer++;
        	s=s.substring(1)+s.charAt(0);
		}
        return answer;
    }
}