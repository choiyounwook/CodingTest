import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[][] maps) {
      /*
     * 프로그래머스 level 2 게임 맵 최단거리 1은 지나갈 수 있는 길, 0은 벽 그냥 dfs로 진행하면 호율성에서 탈락
     */
    int N = maps.length;
    int M = maps[0].length;
    int[][] dir = {{1, 0}, {-1, -0}, {0, 1}, {0, -1}};// 상하좌우
    int[][] checkMaps = new int[N][M];

    for (int i = 0; i < checkMaps.length; i++) {
      for (int j = 0; j < checkMaps[i].length; j++) {
        if (maps[i][j] == 1)
          checkMaps[i][j] = -1;
      }
    }

    checkMaps[0][0] = 1;
    Queue<Integer> x = new LinkedList<Integer>();
    Queue<Integer> y = new LinkedList<Integer>();
    x.add(0);
    y.add(0);

    while (!x.isEmpty()) {
      int curx = x.poll();
      int cury = y.poll();
      for (int i = 0; i < dir.length; i++) {
        int newx = curx + dir[i][0];
        int newy = cury + dir[i][1];
        if (newx < 0 || newy < 0 || newx >= N || newy >= M || checkMaps[newx][newy] == 0)
          continue;

        if (checkMaps[newx][newy] == -1 || checkMaps[newx][newy] > (checkMaps[curx][cury] + 1)) {
          checkMaps[newx][newy] = checkMaps[curx][cury] + 1;
          x.add(newx);
          y.add(newy);
        }
      }
    }

    return checkMaps[N - 1][M - 1];
    }
}