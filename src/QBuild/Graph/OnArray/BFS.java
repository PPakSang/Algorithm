package QBuild.Graph.OnArray;

import java.util.*;

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BFS {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    int[][] map;
    boolean[][] visited;

    int col;
    int row;

    //해당 지점부터 방문 안한 곳 완전 탐색
    void solveBFS(int x, int y) {
        Queue<Location> q = new LinkedList<>();

        visited[x][y] = true;
        q.add(new Location(x, y));

        while (!q.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0<=nx && nx<row) && (0<=ny && ny<col) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Location(nx, ny));
                }
            }
        }

    }
}
