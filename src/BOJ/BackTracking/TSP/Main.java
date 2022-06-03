package BOJ.BackTracking.TSP;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] dist;
    static int[][] dp;
    static int checkLast;

    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        checkLast = (1<<N)-1;

        dist = new int[N][N];
        dp = new int[N][1<<N];


        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(temp[j]);
            }
        }


        System.out.println(tsp(0, 1<<0));
    }


    static int tsp(int cur, int visited) {
        if (visited == checkLast) {
            if (dist[cur][0] != 0) return dist[cur][0];

            return 1000001;
        }

        if (dp[cur][visited] != 0) return dp[cur][visited];

        int minDist = 2000000000;

        for (int i = 0; i < N; i++) {
            if ((visited &(1<<i)) == 0 && dist[cur][i] != 0) {
                minDist = Math.min(minDist, tsp(i, visited|(1<<i)) + dist[cur][i]);
            }
        }

        dp[cur][visited] = minDist;

        return minDist;
    }
}
