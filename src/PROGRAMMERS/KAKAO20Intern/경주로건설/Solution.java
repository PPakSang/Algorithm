package PROGRAMMERS.KAKAO20Intern.경주로건설;

import java.util.*;

class Solution {
    int[] dirX = new int[]{1, -1, 0, 0};
    int[] dirY = new int[]{0, 0, 1, -1};

    int[][] visited;

    int answer;
    int n;
    int[][] map;

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;

        n = board.length;

        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }


        map = board;

        dfs(0, 0, 0, 0);
        dfs(0, 0, 2, 0);

        return answer;
    }

    void dfs(int x, int y, int dir, int cost) {
        visited[x][y] = Math.min(visited[x][y], cost);
        if (x == n-1 && y == n-1) {
            answer = Math.min(answer, cost);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];


            if ((0<=nextX && nextX<n) && (0<=nextY && nextY<n) &&
                    map[nextX][nextY] == 0 && (visited[nextX][nextY] >= cost-200)) {

                int nextCost = dir == i ? cost+100 : cost+600;

                if (dir == i) dfs(nextX, nextY, i, nextCost);
                else dfs(nextX, nextY, i, nextCost);
            }
        }

    }


}