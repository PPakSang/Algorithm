package PROGRAMMERS.Graph.순위.정리;
/*
순위를 그래프로 표현하면, 상하 구조
순위를 확정짓는 경우는 나보다 잘하는 사람과 못하는 사람의 수가 전체 사람 수로 확정이 되면 가능

나를 이긴 사람 / 내가 진 사람 으로 나누자

나보다 잘하는 사람 수는 내가 진 사람의 진 사람들 즉 무조건 나보다 잘하는 애들 그래프 탐색
그 반대도 동일
*/

import java.util.*;

public class Solution {
    List<Integer>[][] result;
    boolean[] visited;
    public int solution(int n, int[][] results) {
        int answer = 0;

        //0 : 내가 이긴 사람
        //1 : 내가 진 사람

        result = new List[n+1][2];

        for (int i = 0; i < n+1; i++) {
            result[i][0] = new ArrayList<>();
            result[i][1] = new ArrayList<>();
        }

        for (int[] res : results) {
            int winner = res[0];
            int losser = res[1];

            result[winner][0].add(losser);
            result[losser][1].add(winner);
        }

        for (int i = 1; i < n+1; i++) {
            int count = 0;
            visited = new boolean[n+1];
            visited[i] = true;

            for (int win : result[i][0]) {
                if (!visited[win])
                    count += search(win, 0);
            }

            for (int loss : result[i][1]) {
                if (!visited[loss])
                    count += search(loss, 1);
            }

            if (count == n-1) answer++;
        }

        return answer;
    }

    int search(int who, int type) {
        int count = 1;

        visited[who] = true;

        for (int p : result[who][type]) {
            if (!visited[p]) count += search(p, type);
        }

        return count;
    }
}
