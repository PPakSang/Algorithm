package BOJ.DP.가장큰정사각형;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);


        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            temp = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    int idx = 1;

                    while (i + idx <= n && j + idx <= m) {
                        int check = dp[i+idx][j+idx] - dp[i+idx][j-1] - dp[i-1][j+idx] + dp[i-1][j-1];

                        idx++;

                        if (check != idx*idx) {
                            idx--;
                            break;
                        }

                    }

                    answer = Math.max(answer, idx*idx);
                }
            }
        }


        System.out.println(answer);
        br.close();
    }
}
