package BOJ.floydwarshall.플로이드;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1000000000);
            dp[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            String[] temp = br.readLine().split(" ");

            int n1 = Integer.parseInt(temp[0])-1;
            int n2 = Integer.parseInt(temp[1])-1;
            int w = Integer.parseInt(temp[2]);

            dp[n1][n2] = Math.min(w, dp[n1][n2]);
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] arr : dp) {
            for (int dist : arr) {
                if (dist == 1000000000) dist = 0;
                sb.append(dist).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
