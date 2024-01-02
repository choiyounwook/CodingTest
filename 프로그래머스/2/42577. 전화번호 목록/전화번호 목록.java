import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
HashMap<String, Integer> hash = new HashMap<String, Integer>();
    Arrays.sort(phone_book);
    for (String str : phone_book)
      hash.put(str, 0);

    for (String str : phone_book) {
      for (int i = 0; i < str.length(); i++) {
        if (hash.containsKey(str.substring(0, i)))
          return false;
      }
    }
    return true;
    }
}