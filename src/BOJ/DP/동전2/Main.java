package BOJ.DP.동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int[] dp;
        int[] coin;

        int N = Integer.parseInt(temp[0]);
        int target = Integer.parseInt(temp[1]);

        dp = new int[target+1];
        coin = new int[N];

        for (int i = 0 ; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int change = 1; change < target+1; change++) {
            dp[change] = 100001;

            for (int c : coin) {
                if (change - c < 0) continue;
                else dp[change] = Math.min(dp[change], dp[change-c] + 1);
            }
        }

        System.out.println(dp[target]==100001?-1:dp[target]);
    }
}
