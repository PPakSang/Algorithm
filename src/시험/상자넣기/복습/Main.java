package 시험.상자넣기.복습;

import java.util.*;
import java.io.*;

public class Main {
    static int[] box;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int max = 0;

        box = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(temp[i]);
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
