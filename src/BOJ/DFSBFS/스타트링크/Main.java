package BOJ.DFSBFS.스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;

    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f+1];

        for (int i=1; i<=f; i++) {
            visited[i] = 0;
        }

        if (s == g) {
            System.out.println(visited[s]);
            return;
        }
        visited[s] = 1;
        queue.add(s);

        bfs();

    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int lastStair = queue.poll();
            int up = lastStair+u;
            int down = lastStair-d;

            if (up == g || down == g) {
                System.out.println(visited[lastStair]);
                return;
            }
            if (up <= f) {
                if (visited[up] == 0) {
                    visited[up] = visited[lastStair] + 1;
                    queue.add(up);
                }
            }
            if (1 <= down ) {
                if (visited[down] == 0) {
                    visited[down] = visited[lastStair] + 1;
                    queue.add(down);
                }
            }
        }

        System.out.println("use the stairs");
    }

}
