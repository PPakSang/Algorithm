package BOJ.DP.최소편집;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;

    static int changeCost;
    static int deleteCost;
    static int plusCost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        changeCost = 1;
        deleteCost = 1;
        plusCost = 1;

        String from = br.readLine();
        String to = br.readLine();

        dp = new int[to.length()+1][from.length()+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            char toChar = to.charAt(i-1);
            for (int j = 1; j < dp[0].length; j++) {
                char fromChar = from.charAt(j-1);

                if (fromChar == toChar) {
                    changeCost = 0;
                } else changeCost = 1;

                dp[i][j] = Math.min(Math.min(dp[i-1][j]+plusCost, deleteCost+dp[i][j-1]),dp[i-1][j-1] + changeCost);
            }
        }

        System.out.println(dp[to.length()][from.length()]);
    }
}
