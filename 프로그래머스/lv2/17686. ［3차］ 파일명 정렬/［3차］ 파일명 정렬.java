import java.util.*;
class Solution {
    public String[] solution(String[] files) {
			/**
		 * 파일명 정렬
		 * 
		 * 파일명 : 100글자 이내, 영문으로 시작, 최소 한글자 이상 
		 * 구성 : 영문 대소문자, 숫자, 공백(""), 마침표("."), 빼기 부호("-")
		 * 
		 * */
        
        Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				// HEAD, NUMBER, TAIL 구분
				int startNum = -1;
		    	int endNum = o1.length(); 
				for (int j = 0; j < o1.length(); j++) {
					if(startNum==-1 && o1.charAt(j)>='0' && o1.charAt(j)<='9'){
						startNum = j;
					}else if(startNum!=-1&&(o1.charAt(j)<'0'||o1.charAt(j)>'9')) {
						endNum = j;
						break;
					}
				}
				
				String head1 = o1.substring(0, startNum).toLowerCase();
				int num1 = Integer.parseInt(o1.substring(startNum, endNum));
				
				startNum = -1;
				endNum = o2.length(); 
				for (int j = 0; j < o2.length(); j++) {
					if(startNum==-1 && o2.charAt(j)>='0' && o2.charAt(j)<='9'){
						startNum = j;
					}else if(startNum!=-1&&(o2.charAt(j)<'0'||o2.charAt(j)>'9')) {
						endNum = j;
						break;
					}
				}
				
				String head2 = o2.substring(0, startNum).toLowerCase();
				int num2 = Integer.parseInt(o2.substring(startNum, endNum));
				
				// HEAD 비교
				int headValue = head1.compareTo(head2);
				
				if(headValue == 0)
				{
					return num1 - num2;
				}else return headValue;
			}
		});

        return files;
    }
}