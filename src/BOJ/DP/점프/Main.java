package BOJ.DP.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m;

    static int[][] map;
    static Long[][] memo;


    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());

     m = Integer.parseInt(st.nextToken());

     map = new int[m][m];
     memo = new Long[m][m];

     for (int i=0; i<m; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j=0; j<m; j++) {
             map[i][j] = Integer.parseInt(st.nextToken());
             memo[i][j] = -1L;
         }
     }

     System.out.println(jump(0, 0));

    }

    static Long jump(int x, int y) {
        if ((y == m-1) && (x == m-1)) {
            return 1L;
        }
        if (memo[y][x] != -1) {

            return memo[y][x];
        }

        memo[y][x] = 0L;

        int[] disX = new int[2];
        int[] disY = new int[2];

        disX[0] = map[y][x];
        disX[1] = 0;
        disY[0] = 0;
        disY[1] = map[y][x];

        for (int k=0; k<2; k++) {
            int nextX = x + disX[k];
            int nextY = y + disY[k];
            if ((0<=nextX && nextX<m) && (0<=nextY && nextY<m)) {
                memo[y][x] += jump(nextX, nextY);
            }
        }

        return memo[y][x];
    }
}
