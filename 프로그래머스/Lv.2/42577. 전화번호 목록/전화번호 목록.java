import java.util.HashMap;
class Solution {
    public boolean solution(String[] phone_book) {
    /**
     * 전화번호 목록.
     * 
     */
    boolean answer = true;
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < phone_book.length; i++) {
      map.put(phone_book[i], 1);
    }

    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 1; j < phone_book[i].length(); j++) {
        if (map.containsKey(phone_book[i].subSequence(0, j)))
          return false;
      }
    }
    return answer;
  
    }
}