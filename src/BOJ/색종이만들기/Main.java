package BOJ.색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int[] wb = new int[]{0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, n-1, 0, n-1);
        System.out.println(wb[0]);
        System.out.println(wb[1]);
    }

    static void cutPaper(int rs, int re, int cs, int ce) {
        int num = paper[rs][cs];
        if (rs == re) {
            wb[num]++;
            return;
        }

        for (int i=rs; i<re+1; i++) {
            for (int j=cs; j<ce+1; j++) {
                if (num != paper[i][j]) {
                    cutPaper(rs,(rs+re)/2, cs, (cs+ce)/2);
                    cutPaper((rs+re)/2+1, re, cs, (cs+ce)/2);

                    cutPaper(rs,(rs+re)/2, (cs+ce)/2+1, ce);
                    cutPaper((rs+re)/2+1, re, (cs+ce)/2+1, ce);
                    return;
                }
            }
        }
        wb[num]++;
    }
}
