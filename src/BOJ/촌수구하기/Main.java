package BOJ.촌수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.spi.BreakIteratorProvider;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] parentChild;
    static int t1,t2;
    static int[] relate;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parentChild = new int[n+1][n+1];
        relate = new int[n+1];
        for (int i=1; i<=n; i++) {
            relate[i] = 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

         for (int i=0; i<m; i++) {
             st = new StringTokenizer(br.readLine());

             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());

             parentChild[a][b] = 1;
             parentChild[b][a] = 1;
         }

         relation(t1, t2);
    }

    static void relation(int target1, int target2) {
        addChild(target1);

        while(!queue.isEmpty()) {
            addChild(queue.poll());
        }

        System.out.println(-1);

    }

    static void addChild(int t) {
        for (int i=1; i<=n; i++) {
            if (parentChild[t][i] == 1) {
                if (i == t2) {

                    System.out.println(relate[t]);
                    System.exit(0);
                    return;
                }
                queue.add(i);
                parentChild[t][i] += 1;
                parentChild[i][t] += 1;
                relate[i] = relate[t]+1;
            }
        }
    }
}
