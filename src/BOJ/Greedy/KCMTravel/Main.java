package BOJ.Greedy.KCMTravel;

import java.util.*;
import java.io.*;

/*
공항과의 연결로가 있다
지원 비용이 있는데, 비행기 티켓을 끊으려면 지원 비용 이하만 가능하다

그리고 공항과 공항의 번호 / 이동 비용 / 이동 시간이 주어진다

1번에서 N 번으로 갈건데, 소요시간이 짧은 경우를 찾는다.

근데 시간은 엄청 짧은데 비용이 너무 크면?

일단 같은 공항으로 가는데 무조건 갱신되어야 하는 케이스 -> 비용 더 작고, 더 빠르다
고려해야하는 케이스 -> 비용은 더 드는데 더 빠르다(마지막까지 갈 여유가 있다), 비용이 더 저렴하지만 더 느리다(다른 케이스가 마지막까지 갈 비용이 없을 수 있음)

그니깐 느리게 해당 노드에 도착했다 치더라도 비용이 더 싸서 목적지에 갈 수 있을 수도 있고
빠르게 도착했으면 말할거도 없고

그냥 다 보나? 다 볼 수도 있겠다 공항 100개에 관계 1만개니깐
경로를 저장하고, 해당 경로에서 거쳤던 공항은 안가는거지

기존보다 더 느리고, 비싼 건 볼 필요도 없다.

일반 다익스트라랑 비슷하게 가는데 해당 노드에서 비용이 가장 싼 애 정보, 시간이 가장 빠른 애 정보 두 세트를 들고있는다
0 : 비용이 가장 싼 애
1 : 시간이 가장 빠른 애

둘 중 하나라도 더 싸고 더 빠른 애가 있다면 flag = true 볼 필요가 있는거지

얘들보다 더 비싸고 더 느리면 볼 필요도 없다. 메리트가 없거든
*/
class Airport {
    int node;
    int cost;
    int time;

    Airport(int node, int cost, int time) {
        this.node = node;
        this.cost = cost;
        this.time = time;
    }
}

//class Route {
//    int cost;
//    int time;
//
//    Route(int cost, int time) {
//        this.cost = cost;
//        this.time = time;
//    }
//}

public class Main {
    static List<Airport>[] airports;

    static int N, M, K;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");

            N = Integer.parseInt(temp[0]); //공항의 수
            M = Integer.parseInt(temp[1]); //총 지원 비용
            K = Integer.parseInt(temp[2]); //티켓정보의 수

            airports = new List[N+1];
//            info = new Route[N+1][2];
            dp = new int[N+1][M+1];

            for (int j = 0; j < N+1; j++) {
                airports[j] = new ArrayList<>();
//                info[j][0] = new Route(Integer.MAX_VALUE, Integer.MAX_VALUE);
//                info[j][1] = new Route(Integer.MAX_VALUE, Integer.MAX_VALUE);
                Arrays.fill(dp[j], Integer.MAX_VALUE);
            }

            for (int j = 0; j < K; j++) {
                temp = br.readLine().split(" ");
                int u = Integer.parseInt(temp[0]);
                int v = Integer.parseInt(temp[1]);
                int c = Integer.parseInt(temp[2]);
                int d = Integer.parseInt(temp[3]);

                airports[u].add(new Airport(v, c, d));
            }
            int answer = dijkstra(1, N);

            if (answer != -1)
                sb.append(answer);
//                System.out.println(answer);
            else
                sb.append("Poor KCM");
//                System.out.println("Poor KCM");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Airport> pq = new PriorityQueue<>(new Comparator<Airport>() {
            @Override
            public int compare(Airport o1, Airport o2) {
                if (o1.time == o2.time)
                    return o1.cost - o2.cost;
                return o1.time - o2.time;
            }
        });

        dp[start][0] = 0;
        pq.add(new Airport(start, 0, 0));

        while(!pq.isEmpty()) {
            Airport cur = pq.poll();

            if (cur.node == end) {
                return cur.time;
            }

            if (dp[cur.node][cur.cost] < cur.time) continue;

            for (int i = 0; i < airports[cur.node].size(); i++) {
                Airport next = airports[cur.node].get(i);

                if (cur.cost + next.cost > M) continue;

                if (dp[next.node][cur.cost + next.cost] > cur.time + next.time) {
                    dp[next.node][cur.cost + next.cost] = cur.time + next.time;
                    pq.add(new Airport(next.node, cur.cost+next.cost, cur.time+next.time));
                }
            }
        }

        return -1;
    }

//    static boolean check(Airport cur, Airport next) {
//        int node = next.node;
//        boolean flag = false;
//        //0 이 비용 젤 싼 애, 1 이 시간이 젤 빠른 에
//
//        if (cur.cost + next.cost > M) return false;
//
////        if (info[node][0].cost >= cur.cost + next.cost) {
////            info[node][0].cost = cur.cost + next.cost;
////            flag = true;
////        }
////
////        if (info[node][1].time >= cur.time + next.time) {
////            info[node][1].time = cur.time + next.time;
////            flag = true;
////        }
//
//        if (dp[node][cur.cost + next.cost] >= cur.time + next.time) {
//            dp[node][cur.cost + next.cost] = cur.time + next.time;
//            flag = true;
//        }
//
//        return flag;
//    }
}
