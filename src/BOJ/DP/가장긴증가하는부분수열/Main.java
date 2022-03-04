package BOJ.DP.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(ascNums(0));
    }

    static int ascNums(int start) {

        int min = arr[start];
        int max = arr[start];
        int cnt = 1;
        int cmp = 0;
        for (int i = start+1; i < n; i++) {
            if (arr[i] <= min) {
                cmp = Math.max(cmp, ascNums(i));
            }
            else if (arr[i] > max) {
                max = arr[i];
                cnt++;
            }
        }

        return Math.max(cnt, cmp);
    }
}
