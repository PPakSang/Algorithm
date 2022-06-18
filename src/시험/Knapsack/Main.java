package 시험.Knapsack;

import java.io.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    static int[][] dp;
    static Item[] item;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        dp = new int[N+1][K+1];
        item = new Item[N+1];

        for (int i = 1; i < N+1; i++) {
            temp = br.readLine().split(" ");
            item[i] = new Item(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        for (int i = 1; i < K+1; i++) {
            for (int j = 1; j < N+1; j++) {
                // 가방에 넣을 수 있으면
                if (i >= item[j].weight) {
                    dp[j][i] = Math.max(item[j].value + dp[j-1][i-item[j].weight], dp[j-1][i]);
                } else {
                    dp[j][i] = dp[j-1][i];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
