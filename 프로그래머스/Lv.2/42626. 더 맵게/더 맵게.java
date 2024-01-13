import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
 /**
     * 더 맵게 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */

    int answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (Integer i : scoville)
      queue.add(i);

    while (!queue.isEmpty() && queue.peek() < K) {

      if (queue.size() < 2)
        return -1;

      int num1 = queue.poll();
      int num2 = queue.poll();

      queue.add(num1 + (num2 * 2));
      answer++;

    }

    return answer;
    }
}