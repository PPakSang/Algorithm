package BOJ.floydwarshall.역사;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        dist = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        for (int i = 0 ; i  < I; i++) {
            temp = br.readLine().split(" ");

            int i1 = Integer.parseInt(temp[0])-1;
            int i2 = Integer.parseInt(temp[1])-1;

            dist[i1][i2] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int d1 = dist[i][k];
                    int d2 = dist[k][j];

                    // 경로가 존재할 때만 초기화 해주면 된다
                    if (d1 != -1 && d2 != -1) dist[i][j] = 1;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < T; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0])-1;
            int n2 = Integer.parseInt(temp[1])-1;

            if (dist[n1][n2] != -1) sb.append("-1\n");
            else if (dist[n2][n1] != -1) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
