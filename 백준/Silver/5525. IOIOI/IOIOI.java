import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n  = Integer.parseInt(br.readLine());
    int m  = Integer.parseInt(br.readLine());
    String text = br.readLine();
    int result = 0;
    int cnt = 0;

    for(int i = 1; i<m-1;i++){
      if(text.charAt(i-1)=='I'&&
        text.charAt(i)=='O'&&
      text.charAt(i+1)=='I')
      {
        cnt++;
        i++;
        if(cnt >= n) result++;

      }else cnt=0;

    }
    System.out.println(result);
  }

}