class Solution {
    public int[] solution(int n, int m) {
      int[] answer = new int[2];
        int big = Math.max(n, m);
        int small = Math.min(n, m);
        answer[0]= gcd(big, small);
        answer[1] = (big*small)/answer[0];
        return answer;
    }
	public static int gcd(int big, int small) {
		if(big%small==0) return small;
		return gcd(small, big%small);
	}
}