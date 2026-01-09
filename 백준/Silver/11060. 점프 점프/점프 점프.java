import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] maps = new int[N];
      int[] visited = new int[N];

      String[] input = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
         maps[i] = Integer.parseInt(input[i]);
      }

      Arrays.fill(visited, -1);
      Queue<Integer> queue = new LinkedList<>();
      queue.add(0);
      visited[0] = 0;
      while (!queue.isEmpty()) {
         int current = queue.poll();
         int jump = maps[current];
         for (int i = 1; i <= jump; i++) {
            int next = current + i;
            if (next >= N) {
               break;
            }
            if (visited[next] == -1) {
               visited[next] = visited[current] + 1;
               queue.add(next);
            }
         }
      }
      System.out.println(visited[N - 1]);
   }


}