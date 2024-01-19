class Solution {
    public int solution(int[] numbers, int target) {
      /**
     * 프로그래머스 level2 타겟 넘버 return 타겟 넘버를 만들 수 있는 경우의 수 dfs 깊이 우선 탐색
     */
    int answer = dfs(numbers, 0, 0, target);

    return answer;
  }

  private static int dfs(int[] numbers, int cur, int result, int target) {

    if (cur >= numbers.length) {
      if (target == result)
        return 1;
    } else {
      return dfs(numbers, cur + 1, result + numbers[cur], target)
          + dfs(numbers, cur + 1, result - numbers[cur], target);
    }
    return 0;
  }
}