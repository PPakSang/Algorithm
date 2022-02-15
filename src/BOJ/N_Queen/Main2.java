package BOJ.N_Queen;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    static int n;
    static boolean[][] chess;
    static int cnt = 0;
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++)
                chess[i][j] = false;
        }

        playChess(0);

        System.out.println(cnt);
    }

    static void playChess(int row) {

        boolean[][] temp = new boolean[n][n];
        for (int a=0; a<n; a++) {
            for (int b=0; b<n; b++) {
                temp[a][b] = chess[a][b];
            }
        }

        for (int j=0; j<n; j++) {
            if (!chess[row][j]) {
                int nextL = j;
                int nextM = j;
                int nextR = j;

                if (row == n-1) {
                    cnt++;
                    return;
                }

                for (int k=row+1; k<n; k++) {
                    nextL -= 1;
                    nextR += 1;

                    chess[k][nextM] = true;
                    if (0 <= nextL) {
                        chess[k][nextL] = true;
                    }
                    if (nextR < n) {
                        chess[k][nextR] = true;
                    }

                }

                chess[row][j] = true;
                playChess(row + 1);
                chess = temp;
                temp = new boolean[n][n];
                for (int a=0; a<n; a++) {
                    for (int b=0; b<n; b++) {
                        temp[a][b] = chess[a][b];
                    }
                }
            }
        }






    }
}
