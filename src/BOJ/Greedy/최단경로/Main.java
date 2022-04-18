package BOJ.Greedy.최단경로;
import java.util.*;
import java.io.*;

class Point {
    int node; // 누구랑 연결돼 있는지
    int weight;

    Point (int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Main {

    static int N;
    static int E;
    static int K;

    static List<Point>[] nodes;
    static int[] answer;
    static boolean[] visited;

    static PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
        public int compare(Point o1, Point o2) {
            return o1.weight - o2.weight;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);

        nodes = new List[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            nodes[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            temp = br.readLine().split(" ");

            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);

            nodes[x].add(new Point(y, weight));
        }


        dijkstra(K);

        for (int i = 1 ; i < N+1; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(answer[i]);
            }
        }

    }

    static void dijkstra(int st) {
        answer[st] = 0;

        pq.add(new Point(st, 0));

        while(!pq.isEmpty()) {
            Point p = pq.poll();
            if (visited[p.node]) continue;

            for (Point p2 : nodes[p.node]) {
                if (answer[p2.node] > answer[p.node] + p2.weight) {
                    answer[p2.node] = answer[p.node] + p2.weight;
                    pq.add(new Point(p2.node, answer[p2.node]));
                }
            }

            visited[p.node] = true;
        }
    }
}
