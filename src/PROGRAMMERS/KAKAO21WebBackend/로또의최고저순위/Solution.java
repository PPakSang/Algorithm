package PROGRAMMERS.KAKAO21WebBackend.로또의최고저순위;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        int success = 0;
        
        Map<Integer, Boolean> check = new HashMap<>();

        for (int i : win_nums) {
            check.put(i, true);
        }

        for (int i : lottos) {
            if (i == 0) {
                zero++;
            } else if(check.get(i) != null){
                success++;
            }
        }

        int[] result = {6, 6, 5, 4, 3, 2, 1};

        int[] answer = {result[success+zero], result[success]};
        return answer;
    }
}