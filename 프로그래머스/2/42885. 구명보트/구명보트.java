import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[] people, int limit) {
  /*
     * 프로그래머스 level 2 구명보트 최대 2명 탑승 가능 people : 사람들의 몸무게 limit : 무게 제한 return 필요한 구명보트의 수
     */

    int answer = 0;
    int idx = people.length - 1;
    Integer[] peopleArr = new Integer[people.length];

    for (int i = 0; i < peopleArr.length; i++) {
      peopleArr[i] = people[i];
    }

    Arrays.sort(peopleArr, Collections.reverseOrder());

    for (int i = 0; i <= idx; i++) {

      if (peopleArr[i] + peopleArr[idx] <= limit) {
        answer++;
        idx--;
      } else {
        answer++;
      }
    }

    return answer;
    }
}