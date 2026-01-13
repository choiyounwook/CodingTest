import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

   static int[] stones;

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      stones = new int[N];

      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
         stones[i] = Integer.parseInt(inputs[i]);
      }

      int low = 1;
      int high = 1000000;
      while (low < high) {
         int mid = (low + high) / 2;
         if (check(mid)) {
            high = mid;
         } else {
            low = mid + 1;
         }
      }
      System.out.println(high);


   }

   static boolean check(int K) {
      Queue<Integer> queue = new ArrayDeque<>();
      int N = stones.length;
      boolean[] visited = new boolean[N];

      queue.add(0);
      visited[0] = true;

      while (!queue.isEmpty()) {
         int curr = queue.poll();
         if (curr == N - 1) {
            return true;
         }
         for (int i = curr + 1; i < N; i++) {
            long sum = (long) (i - curr) * (1L + Math.abs((long) stones[i] - stones[curr]));
            if (!visited[i] && sum <= K) {
               visited[i] = true;
               queue.add(i);
            }
         }
      }
      return visited[N - 1];
   }


}