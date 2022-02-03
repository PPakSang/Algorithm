package BOJ.수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Pr {
    public static void main(String[] args) throws IOException {

        //InputStreamReader -> 한개씩 읽는다, Stream 자체가 무언가를 저장하는게 아닌 전송간에 처리하는 느낌
        //Buffer 기능 추가한 것이 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            a[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(countSum(a, m));
    }

    static int countSum(int[] a, int m) {
        int result = 0;

        for (int i=0; i<a.length; i++) {
            int temp = 0;
            temp += a[i];
            if (temp == m) {
                result++;
                continue;
            }
            for (int j=i+1; j<a.length; j++) {
                temp += a[j];
                if (temp > m) break;
                else if(temp == m) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

}
