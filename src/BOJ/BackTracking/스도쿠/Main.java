package BOJ.BackTracking.스도쿠;

import java.util.*;
import java.io.*;

class Location {
    int x;
    int y;

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class  Main {
    static int[][] map = new int[9][9];

    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[] space = new int[9];

    static List<Location>  zero = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    row[i] = row[i] | 1 << map[i][j];
                    col[j] = col[j] | 1 << map[i][j];
                    space[i / 3 * 3 + j / 3] = space[i / 3 * 3 + j / 3] | 1 << map[i][j];
                } else {
                    zero.add(new Location(i, j));
                }
            }
        }

        solve(0);

    }

    static void solve(int i) {
        if (i == zero.size()) {
            for (int j = 0; j < 9; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < 9; k++) {
                    sb.append(map[j][k]);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
            System.exit(0);
        }

        Location temp = zero.get(i);
        int x = temp.x;
        int y = temp.y;

        int r = row[x];
        int c = col[y];
        int s = space[x/3*3 + y/3];

        int possible = ~(r | c | s);

        for (int z = 1; z <= 9; z++) {
            if ((possible & 1<<z) > 0) {
                map[x][y] = z;
                row[x] = row[x] | 1<<z;
                col[y] = col[y] | 1<<z;
                space[x/3*3 + y/3] = space[x/3*3 + y/3] | 1<<z;

                solve(i+1);

                row[x] = r;
                col[y] = c;
                space[x/3*3 + y/3] = s;
                map[x][y] = 0;
            }
        }
    }
}
