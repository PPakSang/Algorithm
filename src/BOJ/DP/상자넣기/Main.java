package BOJ.DP.상자넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] boxes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boxes = new int[n];
        int[] max = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            max[i] = 0;
        }

        for (int j=n-1; j>=0; j--) {
            for (int i=j; i<n; i++) {
                if (boxes[j] < boxes[i]) {
                    max[j] = Math.max(max[j], 1 + max[i]);
                }
            }
        }

        int result = 0;
        for (int m : max) {
            result = Math.max(result, m);
        }

        System.out.println(result+1);

    }
}
