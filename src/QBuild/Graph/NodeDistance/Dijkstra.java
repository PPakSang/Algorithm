package QBuild.Graph.NodeDistance;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//다음에 방문할 수 있는 노드 객체
class Edge {
    //이게 자주 헷갈리는데 여기서 이야기하는 node 는 연결된(connected) node 로 생각
    // me <---------> node
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Dijkstra {
    List<Edge>[] connection;

    boolean[] visited;

    // start 로 부터 다른 점들까지의 dist 를 구하는 것이므로
    int start;
    int[] dist;

    void solveDijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.add(new Edge(start, 0));

        //Edge 는 다음에 방문할 수 있는 노드 객체
        while (!pq.isEmpty()) {
            //Current 는 현재 Start 에서 가장 짧은 거리에 있는 Node 를 의미
            Edge current = pq.poll();

            if (visited[current.node]) continue;

            // 여기 까지 오면 현재 방문할 수 있는 노드 중 가장 거리가 가까운 노드 확정

            // 고놈이랑 연결된 노드를 또 살피자, 즉 거리가 업데이트 될 수도 있는 친구들
            // Next Next? 느낌
            for (Edge next : connection[current.node]) {
                // 현재 b 까지 갈 수 있는 거리 보다, c 에서 a 를 거쳐서 b 로 가는 경로가 더 짧다면 해당 경로를 살펴볼 필요가 있다
                if (dist[next.node] > dist[current.node] + next.weight) {
                    dist[next.node] = dist[current.node] + next.weight;
                    pq.add(new Edge(next.node, dist[next.node]));
                }
            }

            visited[current.node] = true;
        }
    }
}
