package BOJ.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt=0;

    static boolean[] visited;
    static int[] result;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       s = Integer.parseInt(st.nextToken());

       arr = new int[n];
       visited = new boolean[n];
       result = new int[s];

       for (int i=0; i<n; i++) {
           visited[i] = false;
       }

       st = new StringTokenizer(br.readLine());

       for (int i=0; i<n; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }

       Arrays.sort(arr);

       findSum();

       ans.forEach(i -> {
           System.out.println(i);
       });
    }

    static void findSum() {
        if (cnt == s) {
            sb = new StringBuilder();
            String answer = "";
            for (int i : result) {
//                sb.append(i).append(" ");
                answer += i + " ";
            }
//            ans.add(sb.toString());
            ans.add(answer);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result[cnt++] = arr[i];
            findSum();
            cnt--;
            visited[i] = false;
        }
    }
}
