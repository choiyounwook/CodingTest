import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] tops = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         tops[i] = Integer.parseInt(st.nextToken());
      }

      Stack<Integer> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
         while (!stack.isEmpty()) {
            if (tops[stack.peek()] >= tops[i]) {
               sb.append(stack.peek() + 1).append(" ");
               break;
            } else {
               stack.pop();
            }
         }
         if (stack.isEmpty()) {
            sb.append("0 ");
         }
         stack.push(i);
      }
      System.out.println(sb.toString());
   }

}