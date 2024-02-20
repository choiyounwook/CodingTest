import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
         /**
     * 프로그래머스 이중우선순위큐 I 숫자 : 숫자 삽입 D 1 : 큐에서 최댓값 삭제 D -1 : 큐에서 최솟값을 삭제
     */
    int[] answer = new int[2];
    PriorityQueue<Integer> minpq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int i = 0; i < operations.length; i++) {
      String str[] = operations[i].split(" ");
      int num = Integer.parseInt(str[1]);

      if (str[0].equals("I")) {
        minpq.add(num);
        maxpq.add(num);
      } else {
        if (maxpq.isEmpty())
          continue;
        if (num < 0) {
          int d = minpq.poll();
          maxpq.remove(d);
        } else {
          int d = maxpq.poll();
          minpq.remove(d);
        }
      }
    }
    // 최대
    if (maxpq.isEmpty()) {
      answer[0] = 0;
    } else {
      answer[0] = maxpq.poll();
    }
    // 최소
    if (minpq.isEmpty()) {
      answer[1] = 0;
    } else {
      answer[1] = minpq.poll();
    }

    return answer;
    }
}