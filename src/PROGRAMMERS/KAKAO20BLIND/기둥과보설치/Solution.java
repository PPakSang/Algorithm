package PROGRAMMERS.KAKAO20BLIND.기둥과보설치;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        solution(5, new int[][] {
//                {0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},
//                {1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},
//                {1,1,1,0},{2,2,0,1}
                {0,0,0,1},{0,1,1,1},{0,1,0,1},{0,2,1,1}
        });
    }

    static int[][] map;
    static int N;
    static int cnt;
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        N = n+1;
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = -1; //설치되지 않았음
            }
        }

        for (int[] task : build_frame) {
            int x = task[0];
            int y = task[1];
            int stuff = task[2];
            int whichTask = task[3];

            if (whichTask == 1) {
                if (addStuff(x, y, stuff)) {
                    cnt++;
                    if (map[x][y] != -1) map[x][y] = 2; //보 + 기둥
                    else {
                        map[x][y] = stuff;
                    }
                }
            }
            else {
                boolean result = false;
                int temp = map[x][y];

                if (map[x][y] == 2) {
                    map[x][y] -= stuff+1;
                    result = removeStuff(x, y, stuff);
                } else if(map[x][y] != -1){
                    map[x][y] = -1;
                    result = removeStuff(x, y, stuff);
                }

                if (result) {
                    cnt--;
                } else {
                    map[x][y] = temp;
                }
            }
        }

        answer = new int[cnt][3];
        int cur = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    answer[cur++] = new int[]{i, j, 0};
                    answer[cur++] = new int[]{i, j, 1};
                } else if (map[i][j] == 0) {
                    answer[cur++] = new int[]{i, j, 0};
                } else if (map[i][j] == 1) {
                    answer[cur++] = new int[]{i, j, 1};
                }
            }
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if(o1[1] == o2[1]) {
                        return o1[2] - o2[2];
                    }
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        return answer;
    }


    public static boolean addStuff(int x, int y, int stuff) {
        if (stuff == 0) {
            if (y == 0) return true;
            else if (isThereLine(x, y-1) || isThereBo(x-1, y) || isThereBo(x, y)){
                // 기둥이 내 밑에 있거나, 내 왼쪽에 보가 있거나 내 위치에 보가 있거나
                return true;
            } else return false;
        } else {
            if ((isThereBo(x-1, y) && isThereBo(x+1, y)) ||
                    isThereLine(x, y-1) || isThereLine(x+1, y-1)) {
                // 내 좌 우로 보가 있거나, 내 아래에 기둥이 있거나, 내 우측 아래에 기둥이 있거나
                return true;
            } else return false;
        }
    }
    public static boolean removeStuff(int x, int y, int stuff) {
        boolean result = true;
        if (stuff == 0) {
            if (result && isThereLine(x, y+1)) {
                result = result && addStuff(x, y+1, 0);
            }
            if (result && isThereBo(x, y+1)){
                result = addStuff(x, y+1, 1);
            }
            if (result && isThereBo(x-1, y+1)) {
                result = addStuff(x-1, y+1, 1);
            }
        } else {
            if (result && isThereBo(x-1, y)) {
                result = addStuff(x-1, y, 1);
            }

            if (result && isThereBo(x+1, y)) {
                result = addStuff(x+1, y, 1);
            }

            if (result && isThereLine(x, y)) {
                result = addStuff(x, y, 0);
            }

            if (result && isThereLine(x+1, y)) {
                result = addStuff(x+1, y, 0);
            }
        }

        return result;
    }

    public static boolean isThereLine(int x, int y) {
        if ((0<=x && x<N) && (0<=y && y<N-1)) {
            if (map[x][y] == 0 || map[x][y] == 2) return true;
        }

        return false;
    }

    public static boolean isThereBo(int x, int y) {
        if ((0<=x && x<N-1) && (0<=y && y<N)) {
            if (map[x][y] == 1 || map[x][y] == 2) return true;
        }

        return false;
    }
}
