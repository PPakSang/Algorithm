package 시험.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] queen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        queen = new int[N][N];

        System.out.println(NQueen(N, 0));
    }

    static int NQueen(int N, int nextLine) {
        if (nextLine == N) return 1;


        int answer = 0;

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 1; j <= nextLine; j++) {
                int nextR = nextLine - j;
                int nextDig = i - j;
                int nextDigR = i + j;

                if (nextDig >= 0) {
                    if (queen[nextR][nextDig] == 1) {
                        flag = false;
                        break;
                    }
                }

                if (nextDigR < N) {
                    if (queen[nextR][nextDigR] == 1) {
                        flag = false;
                        break;
                    }
                }

                if (queen[nextR][i] == 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                queen[nextLine][i] = 1;
                answer += NQueen(N, nextLine+1);
                queen[nextLine][i] = 0;
            }
        }

        return answer;
    }
}
