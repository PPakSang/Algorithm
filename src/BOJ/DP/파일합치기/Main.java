package BOJ.DP.파일합치기;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[][] dp;
            int[] sum;

            int N = Integer.parseInt(br.readLine());

            dp = new int[N+1][N+1];
            sum = new int[N+1];

            String[] temp = br.readLine().split(" ");

            for (int j = 1; j < N+1; j++) {
                int next = Integer.parseInt(temp[j-1]);
                sum[j] = sum[j-1] + next;
            }


            // dp[from][to] from - to 까지 합한 파일의 최솟값
            // k : 몇장씩 합칠래, 1장씩 합쳐보고, 2장씩 합쳐보고(1장씩 합친 것의 최솟값), 3장씩 합쳐보고(1, 2장씩 합친 것의 최솟값)
            for (int k = 1; k < N+1; k++) {
                for (int from = 1; from+k < N+1; from++) {
                    int to = from+k;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int div = from; div < to; div++) {
                        dp[from][to] = Math.min(dp[from][to],
                                dp[from][div] + dp[div+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }

            for (int ii = 1 ; ii < N+1; ii++) {
                for (int jj = 1; jj < N+1; jj++) {
                    System.out.printf("%5d ",dp[ii][jj]);
                }
                System.out.println();
            }
            System.out.println(dp[1][N]);
        }
    }
}
