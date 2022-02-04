package BOJ.피보나치수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        List<Long> list = new ArrayList<>();

        list.add(0L);
        list.add(1L);
        list.add(1L);

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }
        else {
            for (int i = 3; i <=n; i++) {
                list.add(list.get(i-2) + list.get(i-1));
            }
        }
        System.out.println(list.get(n));
    }
}
