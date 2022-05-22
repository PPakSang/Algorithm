package PROGRAMMERS.Graph.순위;

/*
한 선수에 대해서 이긴 사람들과 진 사람들로 저장한다
이긴 사람들 연관관계를 탐색, 진 사람들 연관관계 탐색
내가 이긴 애들은, 그 애들의 진 애들을 봐야하고
내가 진 애들은, 그 애들의 이긴 애들을 봐야한다.
*/


import java.util.*;


class Solution {
    List<Integer>[][] rel;
    boolean[] visited;

    public int solution(int n, int[][] results) {
        int answer = 0;

        rel = new List[n+1][2];

        for (int i = 0; i < n+1; i++) {
            rel[i][0] = new ArrayList<>();
            rel[i][1] = new ArrayList<>();
        }

        for (int[] res : results) {
            int winner = res[0];
            int losser = res[1];

            rel[winner][1].add(losser);
            rel[losser][0].add(winner);
        }

        for (int i = 1; i < n+1; i++) {
            int count = 0;
            visited = new boolean[n+1];
            visited [i] = true;
            // System.out.print(i + ":");
            //내가 이긴 애들은 진 애들 탐색
            for (int win : rel[i][1]) {
                // if (i == 4)
                //     System.out.println(win);
                if (!visited[win])
                    count += search(win, 1);
            }
            //내가 진 애들은 이긴 애들 탐색
            for (int loss : rel[i][0]) {
                if (!visited[loss])
                    count += search(loss, 0);
            }
            // System.out.println();

            if (count == n-1) answer++;
        }


        return answer;
    }

    int search(int who, int type) {
        int count = 1;
        visited[who] = true;
        // System.out.print(who + " ");

        for (int result : rel[who][type]) {
            if (!visited[result]) {
                count += search(result, type);
            }
        }

        return count;
    }
}
