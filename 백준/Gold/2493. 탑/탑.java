import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] tops = new int[N];

      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
         tops[i] = Integer.parseInt(inputs[i]);
      }

      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < N; i++) {
         while (!stack.isEmpty()) {
            if (tops[stack.peek()] >= tops[i]) {
               System.out.print((stack.peek() + 1) + " ");
               break;
            } else {
               stack.pop();
            }
         }
         if (stack.isEmpty()) {
            System.out.print("0 ");
         }
         stack.push(i);
      }
   }

}