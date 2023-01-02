import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        /**
         * 조건 1. 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
         * */
        for(int num=arrayA[0];num>1;num--) {
        	if(arrayA[0]%num!=0) continue;
        	boolean flag=true;
        	for (int i = 1; i < arrayA.length; i++) {
        		if(arrayA[i]%num!=0) {flag=false;break;}
			}
        	if(!flag)continue;
        	for (int i = 0; i < arrayB.length; i++) {
        		if(arrayB[i]%num==0) {flag=false;break;}
			}
        	if(!flag)continue;
        	answer=Math.max(answer, num);
        	break;
        }
        /**
         * 조건 2.영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
         * */
        for(int num=arrayB[0];num>1;num--) {
        	if(arrayB[0]%num!=0) continue;
        	boolean flag=true;
        	for (int i = 1; i < arrayB.length; i++) {
        		if(arrayB[i]%num!=0) {flag=false;break;}
			}
        	if(!flag)continue;
        	for (int i = 0; i < arrayA.length; i++) {
        		if(arrayA[i]%num==0) {flag=false;break;}
			}
        	if(!flag)continue;
        	answer=Math.max(answer, num);
        	break;
        }
        return answer;
    }
}