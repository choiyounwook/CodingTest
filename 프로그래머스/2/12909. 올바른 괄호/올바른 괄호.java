import java.util.Stack;
class Solution {
    boolean solution(String s) {
    // 올바른 괄호
    // 스택 활용
    boolean answer = true;
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char str = s.charAt(i);
      if (str == '(') {
        stack.add(str);
      } else {
        if (stack.isEmpty())
          return false;
        stack.pop();
      }

    }

    return stack.isEmpty();
    }
}