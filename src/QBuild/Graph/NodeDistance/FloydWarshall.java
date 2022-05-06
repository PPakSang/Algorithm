package QBuild.Graph.NodeDistance;

public class FloydWarshall {

    // node 수 n 일 때 n x n 행렬
    int[][] dist;
    int n;

    void solveFloydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
