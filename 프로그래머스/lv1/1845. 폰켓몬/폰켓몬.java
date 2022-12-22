import java.util.*;
class Solution {
    public int solution(int[] nums) {
       int n = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
        return map.size()<n?map.size():n;
    }
}