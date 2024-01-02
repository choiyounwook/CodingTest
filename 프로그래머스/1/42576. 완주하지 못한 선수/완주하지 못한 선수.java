import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
 /*
     * 완주하지 못하는 선수 participant : 참가자 completion : 완주자 return 완주 못한 선수 이름
     */
    String answer = "";
    HashMap<String, Integer> hash = new HashMap<>();

    for (String person : participant)
      hash.put(person, hash.getOrDefault(person, 0) + 1);
    for (String person : completion)
      hash.put(person, hash.getOrDefault(person, 0) - 1);

    for (String person : hash.keySet()) {
      if (hash.get(person) != 0)
        answer = person;
    }
    return answer;
    }
}