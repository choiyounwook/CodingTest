class Solution {
    public double solution(int[] arr) {
        int total =0;
        for (int i = 0; i < arr.length; i++) {
			total+=arr[i];
		}
        return (double)total/arr.length;
    }
}