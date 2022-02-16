package BOJ.부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       s = Integer.parseInt(st.nextToken());

       arr = new int[n];

       st = new StringTokenizer(br.readLine());

       for (int i=0; i<n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }

       findSum(0, 0);
        System.out.println(cnt);
    }

    static void findSum(int start, int sum) {

        for (int i=start; i<n; i++) {
            if ((sum + arr[i]) == s) {
                cnt++;
            }
            sum += arr[i];
            findSum(i+1, sum);
            sum -= arr[i];
        }
    }
}
