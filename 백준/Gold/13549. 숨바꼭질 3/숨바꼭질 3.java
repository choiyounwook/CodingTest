import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 0 ≤ N ≤ 100,000
      int k = Integer.parseInt(st.nextToken()); // 0 ≤ K ≤ 100,000
      int[] visited = new int[100001];
      Arrays.fill(visited, Integer.MAX_VALUE);
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(n);
      visited[n] = 0;
      while (!queue.isEmpty()) {
         int idx = queue.poll();
         if (idx == k) {
            break;
         }

         // 뒤로 가기(X-1)
         int back = idx - 1;
         if (back >= 0 && visited[back] > (visited[idx] + 1)) {
            visited[back] = visited[idx] + 1;
            queue.add(back);
         }

         // 앞으로 가기(X+1)
         int forward = idx + 1;
         if (forward <= 100000 && visited[forward] > (visited[idx] + 1)) {
            visited[forward] = visited[idx] + 1;
            queue.add(forward);
         }
         // 순간이동(2*X)
         int teleport = idx * 2;
         if (teleport <= 100000 && visited[teleport] > visited[idx]) {
            visited[teleport] = visited[idx];
            queue.add(teleport);
         }
      }
      System.out.println(visited[k]);
   }

}