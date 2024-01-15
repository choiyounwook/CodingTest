import java.util.*;
import java.util.HashSet;
class Solution {
static boolean[] checkNumber;
  static HashSet<Integer> set = new HashSet<>();

  static public int solution(String numbers) {
    /*
     * 소수찾기; number2의 숫자들을 조합해서 소수 만들기; 나올 수 있는 소수의 수는?
     */

    checkNumber = new boolean[numbers.length()];

    int answer = 0;
    dfs(numbers, 0, "");
    return set.size();
  }

  static void dfs(String numbers, int cur, String result) {

    if (cur >= numbers.length()) {
      if (result == "")
        return;
      int num = Integer.parseInt(result);
      if (isPrime(num))
        set.add(num);
    } else {
      for (int i = 0; i < numbers.length(); i++) {
        if (!checkNumber[i]) {
          checkNumber[i] = true;
          dfs(numbers, cur + 1, result + numbers.charAt(i));
          dfs(numbers, cur + 1, result);
          checkNumber[i] = false;
        }
      }
    }
  }

  static boolean isPrime(int num) {
    if (num < 2)
      return false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }
}