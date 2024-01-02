import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
    int div = nums.length / 2;
    HashMap<Integer, Integer> hash = new HashMap<>();

    for (Integer num : nums) {
      hash.put(num, hash.getOrDefault(num, 0) + 1);
    }

    return Math.min(div, hash.size());
    }
}