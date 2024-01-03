import java.util.*;
class Solution {
 public static int[] solution(String[] genres, int[] plays) {
    /**
     * 속한 노래가 많이 재생된 장르 먼저 장르 내에서 많이 재생된 노래 먼저 장르 내에서 재생 횟수가 같은 노래 중에서 고유 번호가 낮은 노래 먼저 인덱스가 고유번호
     */


    HashMap<String, Integer> hash = new HashMap<String, Integer>();

    // 가장 많이 재생된 장르 선택
    for (int i = 0; i < genres.length; i++) {
      hash.put(genres[i], hash.getOrDefault(genres[i], 0) + plays[i]);
    }
    // 가장 많이 재생된 노래 선택
    List<String> keys = new ArrayList<>(hash.keySet());
    keys.sort((o1, o2) -> hash.get(o2) - hash.get(o1));

    // 징르 별로 플레이 순으로 정렬
    List<Integer> answer = new ArrayList<>();
    for (String key : keys) {
      List<Music> musicList = new ArrayList<>();
      for (int i = 0; i < genres.length; i++) {
        if (genres[i].equals(key))
          musicList.add(new Music(i, plays[i]));
      }
      Collections.sort(musicList, (o1, o2) -> o2.play - o1.play);
      for (int j = 0; j < musicList.size() && j < 2; j++) {
        answer.add(musicList.get(j).idx);
      }
    }
    for (int i : answer)
      System.out.println(i);
    int[] result = answer.stream().mapToInt(i -> i).toArray();
    return result;
  }

  static class Music {

    int idx;
    int play;

    public Music(int idx, int play) {
      this.idx = idx;
      this.play = play;
    }
  }

}