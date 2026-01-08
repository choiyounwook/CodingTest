import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      int N = Integer.parseInt(input[0]); // 돌의 개수
      int K = Integer.parseInt(input[1]); // 쓸 수 있는 최대 힘
      int[] stones = new int[N];
      input = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
         stones[i] = Integer.parseInt(input[i]);
      }
      boolean result = true;
      int[] visited = new int[N];
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(0);
      while (!queue.isEmpty()) {
         int current = queue.poll();
         for (int i = current + 1; i < N; i++) {
            int sum = (1+Math.abs(stones[current] - stones[i])) * (i - current);
            if (visited[i] == 0 && sum <= K) {
               visited[i] = sum;
               queue.add(i);
            }
         }
      }

      System.out.println(visited[N - 1] != 0 ? "YES" : "NO");
   }

}