class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
			long number = numbers[i];
			if(number%2==0)
			{
				answer[i] = number+1;
				continue;
			}
			String bits = Long.toString(number, 2);
			int zeroIndex = bits.lastIndexOf("0");
			if(zeroIndex<0)
			{// 0이 없는 경우 두번째 위치에 0 삽입
				bits= "10"+bits.substring(1);
				answer[i] = Long.parseLong(bits, 2);
			}else {
				// 0이 있는 경우,
				// 마지막 0을 1로 변경, 마지막 0 뒤 1을 0으로 변경
				bits= bits.substring(0,zeroIndex)+"10"+bits.substring(zeroIndex+2,bits.length());
				answer[i] = Long.parseLong(bits, 2);
			}
		}
        return answer;
    }
}