import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine()); // 2<=N<=100000
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] solution = new int[N];
      for (int i = 0; i < N; i++) {
         solution[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(solution);
      int right = N - 1;
      int left = 0;
      int sum = Integer.MAX_VALUE;
      int idx1 = 0;
      int idx2 = 0;
      while (left < right) {
         int cur = solution[left] + solution[right];
         if (Math.abs(cur) < Math.abs(sum)) {
            sum = cur;
            idx1 = left;
            idx2 = right;
         }

         if (cur < 0) {
            left++;
         } else {
            right--;
         }
      }
      System.out.println(solution[idx1] + " " + solution[idx2]);
   }

}