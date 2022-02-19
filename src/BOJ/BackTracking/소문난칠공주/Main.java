package BOJ.BackTracking.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] table = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int princesses = 0;

    static int[] dirx = new int[]{1, -1, 0, 0};
    static int[] diry = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<5; i++) {
            String line = br.readLine();
            for (int j=0; j<5; j++) {
                table[i][j] = line.charAt(j);
                visited[i][j] = false;
            }
        }
        selectPeople(0,0, 0);
        System.out.println(princesses);

    }

    static void selectPeople(int idx, int cnt, int cntY) {
        if (cntY > 3) {
            return;
        }
        if (cnt == 7) {
            checkPrincess();
            return;
        }

        for (int i=idx; i<25; i++) {
            visited[i/5][i%5] = true;
            if (table[i/5][i%5] == 'Y') {
                selectPeople(i+1, cnt+1, cntY+1);
            }
            else {
                selectPeople(i+1, cnt+1, cntY);
            }
            visited[i/5][i%5] = false;
        }
    }

    static boolean checkPrincess() {
        boolean[][] adj = new boolean[5][5];
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int num=0; num<25; num++) {
            int i = num/5;
            int j = num%5;

            if (visited[i][j]) {
                adj[i][j] = true;
                queue.add(num);
               while (!queue.isEmpty()) {
                   int nextNum = queue.poll();
                   for (int k = 0; k < 4; k++) {
                       int x = nextNum/5 + dirx[k];
                       int y = nextNum%5 + diry[k];
                       if ((0 <= x && x < 5) && (0 <= y && y < 5)) {
                           if (visited[x][y]) {
                               if (adj[x][y]) continue;
                               queue.add(x*5+y);
                               adj[x][y] = true;
                               cnt++;
                           }
                       }
                   }
               }

            }
        }
        if (cnt == 7)  princesses++;

        return true;

    }

}
