package BOJ.BinarySearch.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];

        int max = 0;
        int min = 0;

        for (int i=0; i<n; i++) {
            trees[i] = Integer.valueOf(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }


        while(max >= min) {

            long sum = 0;
            int mid = (max + min) / 2;

            for (int tree : trees) {

                if (tree - mid > 0) {
                    sum += (tree - mid);
                }

            }

           if (sum >= m) {
               min = mid + 1;
           }
           else {
               max = mid - 1;
           }
        }

        System.out.println(max);
    }
}
