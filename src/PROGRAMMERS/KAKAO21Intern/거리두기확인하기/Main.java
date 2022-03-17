package PROGRAMMERS.KAKAO21Intern.거리두기확인하기;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Character[][] table;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static boolean[][] visited;
    public static int[] solution(String[][] places) {

        int[] answer = new int[5];
        table = new Character[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    table[j][k] = places[i][j].charAt(k);
                }
            }
            answer[i] = check();
        }

        return answer;
    }


    public static int check() {

        int temp = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (table[i][j].equals('P')) {
                    visited[i][j] = true;
                    temp = dfs(i, j, 0);
                    visited[i][j] = false;

                    if (temp == 0) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static int dfs(int x, int y, int cnt) {

        if (cnt == 3) {
            return 1;
        }

        int temp = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];

            if ((0<=nextX && nextX<5) && (0<=nextY && nextY<5) && !visited[nextX][nextY]) {
                switch (table[nextX][nextY]) {
                    case 'P':
                        temp = 0;
                        break;
                    case 'X':
                        break;
                    case 'O':
                        visited[nextX][nextY] = true;
                        temp = dfs(nextX, nextY, cnt+1);
                        visited[nextX][nextY] = false;
                        break;
                }
            }

            if (temp == 0 && cnt < 2) return 0;
        }
        return 1;
    }
}
