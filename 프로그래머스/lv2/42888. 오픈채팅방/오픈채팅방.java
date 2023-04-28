import java.util.*;
class Solution {
    public String[] solution(String[] record) {
/**
    	 * 오픈채팅방
    	 * 
    	 * 인/아웃 아이디 닉네임
    	 * */
    	Map<String, String> nick = new HashMap<>();
    	List<String> list = new ArrayList<>();
    	
    	for (int i = 0; i < record.length; i++) {
			String str = record[i];
			String[] strArr = str.split(" ");
			if(strArr[0].equals("Enter")||strArr[0].equals("Change")) {
				nick.put(strArr[1], strArr[2]);
			}
		}
    	for (int i = 0; i < record.length; i++) {
    		String str = record[i];
			String[] strArr = str.split(" ");
			String out = nick.get(strArr[1]);
			if(strArr[0].equals("Enter")) {
				out+="님이 들어왔습니다.";
				list.add(out);
			}else if(strArr[0].equals("Leave")){
				out+="님이 나갔습니다.";
				list.add(out);
			}
		}

        return list.toArray(new String[0]);
    }
}