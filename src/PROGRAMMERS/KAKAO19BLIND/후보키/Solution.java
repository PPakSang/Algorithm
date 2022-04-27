package PROGRAMMERS.KAKAO19BLIND.후보키;
import java.util.*;

public class Solution {

        List<Integer> bit = new ArrayList<>();

        public int solution(String[][] relation) {
            int answer = 0;
            Map<String, List<Integer>> record;
            int col = relation[0].length;
            int row = relation.length;

            for (int i = 1; i < 1<<col; i++) {
                Set<String> comb = new HashSet<>();

                for (int j = 0; j < row; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < col; k++) {
                        if ((1<<k & i) > 0) sb.append(relation[j][k]);
                    }
                    comb.add(sb.toString());
                }

                if (comb.size() == row && check(i)) {
                    bit.add(i);
                }
            }

            return bit.size();
        }



        boolean check(int i) {
            for (Integer k : bit) {
                if ((k & i) == k) return false;
            }
            return true;
        }
}
