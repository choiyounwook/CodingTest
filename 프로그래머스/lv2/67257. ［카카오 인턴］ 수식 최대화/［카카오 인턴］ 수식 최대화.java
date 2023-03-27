import java.util.*;
class Solution {
	private static long maxNum = 0;
	public static long solution(String expression) {
		/**
		 * 수식 최대화
		 * */
		ArrayList<Long> numbers = new ArrayList<>();
		ArrayList<String> ops = new ArrayList<>();
        long answer = 0;
        String num = "";
        // 숫자 추출
        for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)>='0' && expression.charAt(i)<='9')
			{
				num+=expression.charAt(i);
				
			}else {
				numbers.add(Long.parseLong(num));
				num = "";
				ops.add(expression.charAt(i)+"");
			}
		}
        numbers.add(Long.parseLong(num));
        return calc(numbers,ops);
    }
	
	public static long calc(ArrayList<Long> numbers, ArrayList<String> ops) {
		String op[][] = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
		
		for (int i = 0; i < op.length; i++) {
			ArrayList<Long> tempList = new ArrayList<>(numbers);
			ArrayList<String> tempops = new ArrayList<>(ops);
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < tempops.size(); k++) {
					if(tempops.get(k).equals(op[i][j]))
					{
						tempList.set(k, sum(tempList.get(k),tempList.get(k+1),tempops.get(k)));
						tempops.remove(k);
						tempList.remove(k+1);
						k--;
					}
				}
			}
			maxNum = Math.max(Math.abs(tempList.get(0)), maxNum);
		}
		return maxNum;
	}
	
	public static long sum(Long n1, Long n2, String op) {

		if(op.equals("+"))
		{
			return n1+n2;
		}else if(op.equals("-")) {
			return n1-n2;
		}
		return n1*n2;
	}
}