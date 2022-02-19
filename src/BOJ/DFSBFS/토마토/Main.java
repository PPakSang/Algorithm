package BOJ.DFSBFS.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Dir {
    int x;
    int z;
    int y;

    Dir(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}


public class    Main {
    static int[][][] tomato;
    static int[] dir = new int[]{1,-1};
    static int m;
    static int n;
    static int h;
    static Queue<Dir> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomato = new int[h][n][m];

        for(int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        queue.add(new Dir(i,j,k));
                    }
                }
            }
        }
        ripe();
        int max =0;
        for(int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(tomato[i][j][k], max);
                }
            }
        }

        System.out.println(max-1);
    }

    static void ripe() {
        while (!queue.isEmpty()) {
            Dir d = queue.poll();
            int x = d.x;
            int y = d.y;
            int z = d.z;

            for (int i : dir) {
                int nx = x+i;
                int ny = y+i;
                int nz = z+i;

                if (0<=nx && nx<h) {
                    if (tomato[nx][y][z] == 0) {
                        tomato[nx][y][z] = tomato[x][y][z]+1;
                        queue.add(new Dir(nx, y, z));
                    }
                }
                if (0<=ny && ny<n) {
                    if (tomato[x][ny][z] == 0) {
                        tomato[x][ny][z] = tomato[x][y][z]+1;
                        queue.add(new Dir(x, ny, z));
                    }
                }
                if (0<=nz && nz<m) {
                    if (tomato[x][y][nz] == 0) {
                        tomato[x][y][nz] = tomato[x][y][z]+1;
                        queue.add(new Dir(x, y, nz));
                    }
                }
            }

        }
    }
}
