package BOJ.DP.상자넣기.복습;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] boxes = new int[n];
        int[] dp = new int[n];

        String[] temp = br.readLine().split(" ");

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < temp.length; i++) {
            boxes[i] = Integer.parseInt(temp[i]);

            for (int j = i-1; j >= 0; j--) {
                if (boxes[i] > boxes[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
