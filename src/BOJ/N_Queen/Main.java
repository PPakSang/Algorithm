package BOJ.N_Queen;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] chess;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new int[n];

        for (int i=0; i<n; i++) {
                chess[i] = 0;
        }

        playChess(0);

        System.out.println(cnt);
    }

    static void playChess(int row) {

        if (row == n) {
            cnt++;
            return;
        }
        for (int next = 0; next < n; next++) {
            chess[row] = next;
            if (check(row)) {
                playChess(row+1);
            }
        }
    }

    static boolean check(int row) {

        for (int i = 0; i < row; i++) {
            if (Math.abs(chess[i] - chess[row]) == 0 || Math.abs(chess[i] - chess[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

}
