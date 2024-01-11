class Solution {
    public int[] solution(int[] answers) {
 /*
     * 모의고사 ㄹ 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2,
     * 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2,
     * 4, 4, 5, 5, ...
     */

    int[][] student = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    int[] result = new int[3];
    int maxNum = 0;
    int maxCnt = 0;
    // 학생 1
    for (int i = 0; i < student.length; i++) {

      int max = student[i].length;
      int cnt = 0;
      for (int j = 0; j < answers.length; j++) {

        if (answers[j] == student[i][j % max])
          cnt++;
      }
      result[i] = cnt;
      maxNum = Math.max(maxNum, cnt);
    }
    for (int i = 0; i < result.length; i++) {
      if (result[i] == maxNum)
        maxCnt++;
    }
    int[] answer = new int[maxCnt];

    for (int i = 0, j = 0; i < result.length; i++) {
      if (result[i] == maxNum)
        answer[j++] = i + 1;
    }
    return answer;
    }
}