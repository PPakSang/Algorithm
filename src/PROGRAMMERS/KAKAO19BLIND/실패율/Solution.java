package PROGRAMMERS.KAKAO19BLIND.실패율;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    static class Index {
        double rate;
        int index;

        public Index(double rate, int index) {
            this.rate = rate;
            this.index = index;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] reach = new int[N+1];
        int[] fail = new int[N+2];
        Index[] rate = new Index[N+1];

        int[] answer = new int[N];

        for (int cur : stages) {
            fail[cur]++;
        }
        reach[N] = fail[N]+fail[N+1];
        for (int i = N-1; i >= 1; i--) {
            reach[i] = fail[i] + reach[i+1];
        }

        for (int i = 1; i <= N; i++) {
            if (reach[i] != 0) {
                rate[i] = new Index(fail[i] / (double) reach[i], i);
            } else {
                rate[i] = new Index(0, i);
            }
        }
        rate[0] = new Index(Double.MAX_VALUE, 0);

        Arrays.sort(rate, new Comparator<Index>() {
            @Override
            public int compare(Index o1, Index o2) {
                if (o1.rate == o2.rate) {
                    return o1.index - o2.index;
                }
                return o1.rate > o2.rate ? -1 : 1;
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = rate[i+1].index;
        }

        return answer;
    }
}
