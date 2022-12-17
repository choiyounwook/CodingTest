import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        /*
		 * 1번 수포자 : 1, 2, 3, 4, 5 --- 1~5 순서대로
		 * 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5 --- 2, {1,3,4,5} 번갈아서
		 * 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3 ----{3},{1},{2},{4},{5} 반복
		 * 동점 자가 여럿일 경우 오름차순으로 정렬
		 * */
        int[]  student = {0,0,0};
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        // 1번
        for (int i = 0; i < answers.length; i++, flag1++,flag2++, flag3++) {
			// 1번
        	if(flag1>=student1.length) flag1=0;
			if(student1[flag1]==answers[i]) student[0]++;
			
			// 2번
			if(flag2>=student2.length) flag2=0;
			if(student2[flag2]==answers[i]) student[1]++;
			
			// 3번
			if(flag3>=student3.length) flag3=0;
			if(student3[flag3]==answers[i]) student[2]++;			
		}
        int max =0;
        for (int i = 0; i < student.length; i++) {
        	
			max = Math.max(max, student[i]);
		}
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < student.length; i++) {
			if(max==student[i]) list.add(i+1);
		}
        return list;
    }
}