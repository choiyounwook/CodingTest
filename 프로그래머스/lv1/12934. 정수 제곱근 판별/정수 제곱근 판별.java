class Solution {
    public long solution(long n) {
       long answer = 0;
        double num = Math.sqrt(n);
        if(num%1!=0) return -1;
        return (long) Math.pow(num+1, 2);
    }
}