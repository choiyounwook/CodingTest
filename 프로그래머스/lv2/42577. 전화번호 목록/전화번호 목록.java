import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
       /**
    	 * 전화번호 목록
    	 * phone_book : 전화번호부
    	 * 전화번호 부에 적힌 번호 중 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
    	 * 
    	 * 이중for문만 사용 시 효율성 떨어짐
    	 * */

        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}