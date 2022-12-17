class Solution {
    public boolean solution(int x) {
        int total = x;
        int num = 0;
        while(total!=0) {
        	num+=(total%10);
        	total/=10;
        }
        return (x%num==0?true:false);
    }
}