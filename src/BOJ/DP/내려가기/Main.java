package BOJ.DP.내려가기;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] max = new int[3];
        int[] min = new int[3];
        int[] tempMax = new int[3];
        int[] tempMin = new int[3];

        int[] stage;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < 3; j++) {
                tempMax[j] = max[j];
                tempMin[j] = min[j];
            }

            stage = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            tempMax[0] = Math.max(max[0], max[1]) + stage[0];
            tempMax[1] = Math.max(Math.max(max[0], max[1]), max[2]) + stage[1];
            tempMax[2] = Math.max(max[1], max[2]) + stage[2];


            tempMin[0] = Math.min(min[0], min[1]) + stage[0];
            tempMin[1] = Math.min(Math.min(min[0], min[1]), min[2]) + stage[1];
            tempMin[2] = Math.min(min[1], min[2]) + stage[2];

            for (int j = 0; j < 3; j++) {
                max[j] = tempMax[j];
                min[j] = tempMin[j];
            }
        }

        System.out.println(
                Math.max(Math.max(max[0], max[1]), max[2])
                + " "
                + Math.min(Math.min(min[0], min[1]), min[2])
        );

        br.close();
    }
}
