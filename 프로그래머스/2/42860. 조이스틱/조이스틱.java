class Solution {
    public static int solution(String name) {

    /**
     * 조이스틱 return 조이스틱 조작 횟수의 최솟값
     */

    int answer = 0;
    int move = name.length() - 1;
    for (int i = 0; i < name.length(); i++) {
      answer += checkCharter(name.charAt(i));

      int aPoint = i + 1;

      while (aPoint < name.length() && name.charAt(aPoint) == 'A') {
        aPoint++;
      }
      // 순서대로 가기 vs 뒤로 돌아가기
      move = Math.min(move, (i * 2) + (name.length() - aPoint));
      // 순서대로 가기 vs 뒤에서 먼저 시작하기
      move = Math.min(move, ((name.length() - aPoint) * 2) + i);
    }
    return answer + move;
  }

  public static int checkCharter(char ch) {
    int num1 = ch - 65;
    int num2 = 91 - ch;
    return Math.min(num1, num2);
  }
}