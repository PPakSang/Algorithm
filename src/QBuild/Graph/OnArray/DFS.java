package QBuild.Graph.OnArray;


public class DFS {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    int[][] map;
    boolean[][] visited;

    int col;
    int row;

    //해당 지점부터 방문 안한 곳 완전 탐색
    void solveDFS(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0<=nx && nx<row) && (0<=ny && ny<col) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                solveDFS(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }


}
