import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int totalCheese = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if (st.nextToken().equals("1")) {
					map[i][j] = 1;
					totalCheese++;
				}
			}
		}

		int time = 0;
		while (totalCheese > 0) {
			time++;
			int cheeseLeft = totalCheese - meltCheese(n, m);
			if (cheeseLeft == 0) {
				break;
			}
			totalCheese = cheeseLeft;

		}

		System.out.println(time);
		System.out.println(totalCheese);

	}

	static int meltCheese(int n, int m) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new ArrayDeque<>();
		int melted = 0;
       
		queue.add(new int[] {0, 0});
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newx = pos[0] + dx[i];
				int newy = pos[1] + dy[i];
				if (newx >= 0 && newx < n && newy >= 0 && newy < m && !visited[newx][newy]) {
					visited[newx][newy] = true;
					if (map[newx][newy] == 0) {
						queue.add(new int[] {newx, newy});
					} else if (map[newx][newy] == 1) {
						map[newx][newy] = 0;
						melted++;
					}
				}
			}
		}

		return melted;
	}
}