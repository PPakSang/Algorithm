package BOJ.BackTracking.계단오르기;

import java.util.*;
import java.io.*;

public class Main {
    static int[] box;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        box = new int[N];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Math.max(jump(0, 0), jump(1, 0)));

    }

    static int jump(int num, int cnt) {
        if (num == N-1) return box[N-1];
        else if (num > N-1) return Integer.MIN_VALUE;

        // 이미 한칸 뛰어서 왔다
        if (cnt == 1) {
            if (dp[num][2] != 0) return dp[num][2];
            else return dp[num][2] = jump(num+2, 0)+box[num];
        } else {
            if (dp[num][1] == 0) {
                dp[num][1] = jump(num+1, 1) + box[num];
            }
            if (dp[num][2] == 0) {
                dp[num][2] = jump(num+2, 0) + box[num];
            }

            return Math.max(dp[num][1], dp[num][2]);
        }
    }
}
