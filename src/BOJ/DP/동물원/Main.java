package BOJ.DP.동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] fence = new int[n+1];
        fence[0] = 3;
        fence[1] = 7;
        for (int i=2; i<n; i++) {
            fence[i] = (2*fence[i-1] + fence[i-2])%9901;
        }

        System.out.println(fence[n-1]);
    }
}
