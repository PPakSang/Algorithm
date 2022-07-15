package BOJ.DFSBFS.텀프로젝트;

import java.util.*;
import java.io.*;

public class Main {
    static int[] select;
    static boolean[] hasGroup;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");

            select = new int[N];
            hasGroup = new boolean[N];

            for (int j = 0; j < N; j++) {
                select[j] = Integer.parseInt(temp[j])-1;
            }

            for (int j = 0; j < N; j++) {
                if (!hasGroup[j])
                    hasGroup[j] = checkGroup(j, select[j]);
            }

            int cnt = 0;

            for (boolean g : hasGroup) {
                if (!g) cnt++;
            }

            System.out.println(cnt);
        }
    }

    static boolean checkGroup(int s, int c) {
        if (s == c) return true;
        if (hasGroup[c]) return false;

        hasGroup[c] = true;
        return hasGroup[c] = checkGroup(s, select[c]);
    }

}
