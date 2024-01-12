import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /**
     * 기능 개발 progresses :먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 speeds : 각 작업의 개발 속도 return : 배포마다 몇개의
     * 기능이 배포되는지
     */


    List<Integer> list = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<Integer>();

    for (int i = 0; i < progresses.length; i++) {
      queue.add(i);
    }

    while (!queue.isEmpty()) {

      int cur = queue.poll();
      int cnt = 1;
      int time = (100 - progresses[cur]) / speeds[cur]
          + ((100 - progresses[cur]) % speeds[cur] == 0 ? 0 : 1);

      while (!queue.isEmpty()) {
        int next = queue.peek();
        int h = (100 - progresses[next]) / speeds[next]
            + ((100 - progresses[next]) % speeds[next] == 0 ? 0 : 1);
        if (h > time)
          break;
        queue.poll();
        cnt++;
      }
      list.add(cnt);
    }

    int[] answer = new int[list.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }
    return answer;
    }
}