package BOJ.계란으로계란치기;

import java.io.*;
import java.util.*;

public class Main {
    static int[] s;
    static int[] w;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        int result = maxEggs(0, 0);

        System.out.println(result);
    }

    static int maxEggs(int next, int cnt) {
        int temp = cnt;
        if (next == n) {
            return cnt;
        }
        if (s[next] <= 0) {
            return maxEggs(next+1, cnt);
        }
        for (int i=0; i<n; i++) {
            int egg1 = 0;
            int egg2 = 0;
            if (i == next) continue;
            if (s[i] > 0) {
                s[i] -= w[next];
                s[next] -= w[i];
                if (s[i] <= 0) {
                    egg1 = 1;
                }
                if (s[next] <= 0) {
                    egg2 = 1;
                }
                temp = Math.max(temp, maxEggs(next+1, cnt + egg1 + egg2));
                s[i] += w[next];
                s[next] += w[i];
            }
        }

        return temp;
    }
}
