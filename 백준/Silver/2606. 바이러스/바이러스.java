import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

   static boolean[][] linked;
   static boolean[] checked;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int node = Integer.parseInt(br.readLine());
         linked = new boolean[node+1][node+1];
         checked = new boolean[node+1];

         int egde = Integer.parseInt(br.readLine());
         for(int i=0; i<egde; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            linked[a][b] = linked[b][a] = true;
         }
         
         dfs(1);
         
         int virus_computer = 0;
         for(int i=1; i<=node; i++) {
            if (checked[i]) {virus_computer++;}
         }
         System.out.println(virus_computer-1);

   }

   public static void dfs(int start) {
      checked[start] = true;

      for(int i=1; i<linked.length; i++) {
         if(linked[start][i] && !checked[i]) {
           dfs(i);
         }
      }
   }
}