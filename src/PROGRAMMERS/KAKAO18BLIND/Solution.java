package PROGRAMMERS.KAKAO18BLIND;

import java.util.*;

class Solution {

    int M;
    int N;

    char[][] puzzle;
    boolean[][] visited;

    int answer;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        puzzle = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                puzzle[i][j] = board[i].charAt(j);
            }
        }

        dfs(m, n);

        return answer;
    }


    void dfs(int m, int n) {


        while(true) {
            visited = new boolean[m][n];
            int count = 0;

            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (puzzle[i][j] == '0') continue;
                    if (check(i, j)) {
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i+1][j+1] = true;
                        visited[i][j+1] = true;
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                List<Character> line = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if (!visited[j][i]) {
                        line.add(puzzle[j][i]);
                    }
                }

                int index = line.size() - 1;

                for (int k = m-1; k >= 0; k--) {
                    if (index < 0) {
                        puzzle[k][i] = '0';
                        count++;
                    }
                    else {
                        puzzle[k][i] = line.get(index--);
                    }
                }
            }

            if (count == 0) break;
            answer += count;
        }
    }

    boolean check(int x, int y) {
        if ((puzzle[x][y] == puzzle[x+1][y]) &&
                (puzzle[x][y] == puzzle[x+1][y+1])  &&
                (puzzle[x][y] == puzzle[x][y+1])) return true;
        return false;
    }
}
