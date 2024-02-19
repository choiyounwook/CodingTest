import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
       /**
     * 프로그래머스 디스크 컨트롤러 요청부터 종료까지 걸리는 시간들의 평균
     */
    int answer = 0;
    int now = 0;
    int total = 0;
    int idx = 0;
    Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청 시간이 빠른 순으로 정렬

    PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);

    while (total < jobs.length) {
      // now보다 작거나 같은 요청 시간이 있는가?
      for (int i = idx; i < jobs.length; i++) {
        if (jobs[i][0] <= now) {
          heap.add(jobs[i]);
          idx++;
        }

      }
      // now 보다 작거나 같은 요청 시간이 없다면 now +1
      if (heap.isEmpty()) {
        now++;
        continue;
      }

      // 그 중 실행 시간이 제일 작은 프로세스 시작
      total++;
      int[] process = heap.poll();
      now += process[1];
      answer += (now - process[0]);
    }

    return (int) Math.floor(answer / jobs.length);
    }
}