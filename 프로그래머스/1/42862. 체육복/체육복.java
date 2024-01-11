class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        /**
     * 프로그래머스 체육복 level 1. n : 전체 학생의 수 lost : 체육복을 도난당한 학생들의 번호가 담긴 배열 reverse : 여벌의 체육복을 가져온 학생들의
     * 번호가 담긴 배열 return : 체육 수업 들을 수 있는 학생 수
     */
    int answer = 0;
    int[] student = new int[n];

    // 도난 당한 학생과 여분 옷 있는 학생들 정리
    for (int i = 0; i < lost.length; i++) {
      student[lost[i] - 1]--;
    }

    for (int i = 0; i < reserve.length; i++) {
      student[reserve[i] - 1]++;
    }


    // 옷 빌려주기

    for (int i = 0; i < student.length; i++) {
      if (student[i] >= 0)
        continue;


      if (i == 0) {
        // 맨앞자리 학생인 경우
        if (student[i + 1] > 0) {
          student[i]++;
          student[i + 1]--;
        }
      } else if (i == (n - 1)) {
        // 맨 마지막 학생인 경우
        if (student[i - 1] > 0) {
          student[i]++;
          student[i - 1]--;
        }
      } else {

        if (student[i - 1] > 0) {
          // 앞자리 학생한테 먼저 빌리기
          student[i]++;
          student[i - 1]--;
        } else if (student[i + 1] > 0) {
          // 뒷자리 학생한테 빌리기
          student[i]++;
          student[i + 1]--;
        }
      }
    }


    // 참가 가능한 학생 구하기
    for (int i = 0; i < student.length; i++) {
      if (student[i] >= 0)
        answer++;
    }
    return answer;
    }
}