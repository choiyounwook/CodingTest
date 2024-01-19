class Solution {
    public String solution(String number, int k) {
        /**
     * 프로그래머스 level 2 큰수만들기 number에서 k개의 숫자를 지워 가장 큰 수를 만들어라
     */

    String answer = "";
    int size = number.length() - k;

    while (answer.length() < size) {

      if (k == 0) {
        answer += number;
        return answer;
      }
      int idx = 0;
      char max = '0';
      for (int i = 0; i <= k; i++) {
        if (max < number.charAt(i)) {
          max = number.charAt(i);
          idx = i;
        }
      }

      answer += max;
      number = number.substring(idx + 1, number.length());
      k -= idx;
    }

    return answer;
    }
}