package PRJAVA.tsp;

import java.io.*;
import java.util.*;

/*
dp[start][cur][visited] : start 에서 출발하고, 현재 cur 이고, 현재 visited 집합을 방문했을 때 cur 에서 그 다음에 갈 수 있는 최소 거리


현재 cur 일 때 남은 집합 visited 에서 갈 수 있는 최소 거리를 찾자

1. 만약 visited 가 다 방문했다면, dist[cur][start] 존재 여부 보고, 있으면 반환 없으면 DNF
2. dp[start][cur][visited] 있으면, 즉 다음 경로의 집합이 겹치면 어차피 그 다음 경로는 다 호출 되었으니깐 더 볼 필요 없다.
3. 방문하지 않은 도시 중에 이어져있는 도시 방문
solve(start, nextCity, curpath + " " + nextCity, visited | 1 << nextCity)


solve(start, cur, curPath, visited)
start 에서 출발했고, 현재 cur 도착, visited 일 때


*/

class City {
    Double x;
    Double y;

    public City(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
}

public class TSP {
    static double[][] dist;
    static double[][][] dp;

    static City[] cities;
    static int checkLast;

    static int N;

    static Double answerDist = Double.MAX_VALUE;
    static StringBuilder answerPath = new StringBuilder();

    static boolean N_2_SOLUTION = true;

    static Double calcDist(City c1, City c2) {
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }

    public static void main(String[] args) throws IOException{
        String path = TSP.class.getResource("").getPath();
        BufferedReader br = new BufferedReader(new FileReader(path + "input2.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(path + "output2.txt"));

        N = Integer.parseInt(br.readLine());

        checkLast = (1 << N) - 1;

        cities = new City[N];
        dp = new double[N][N][checkLast+1];
        dist = new double[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            Double x = Double.parseDouble(temp[0]);
            Double y = Double.parseDouble(temp[1]);
            cities[i] = new City(x, y);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                Double dt = calcDist(cities[i], cities[j]);
                dist[i][j] = dt;
                dist[j][i] = dt;
            }
        }

        int iter = N_2_SOLUTION ? N : 1;

        for (int i = 0; i < iter; i++) {
            Double dt = solve(i, i, ""+i, 0.0, 1 << i);
            answerDist = Math.min(answerDist, dt);
        }

        answerPath.append(0 + ",");
        int cur = 0;
        int visited = 1 << 0;

        while (visited != checkLast) {
            int nextCity = 0;
            double min = Double.MAX_VALUE;

            for (int j = 1; j < N; j++) {
                if ((visited & (1<<j)) == 0) {
                    double dt = dp[0][j][visited|(1<<j)];
                    if (min > dt + dist[cur][j]) {
                        min = dt + dist[cur][j];
                        nextCity = j;
                    }
                }
            }

            cur = nextCity;
            visited = visited | (1<<nextCity);
            answerPath.append(nextCity + ",");
        }

        answerPath.append("0");
        pw.println(Math.round(answerDist*100)/100.0);
        pw.println(answerPath.toString());

        pw.close();
    }

    static Double solve(int start, int cur, String curPath, Double curDist, int visited) {
        if (checkLast == visited) {
            if (dist[cur][start] != 0) {
                return dist[cur][start];
            }
            else return Double.MAX_VALUE;
        }

        if (dp[start][cur][visited] != 0) return dp[start][cur][visited];

        double minDist = Double.MAX_VALUE;

        for (int nextCity = 0; nextCity < N; nextCity++) {
            if ((visited & (1 << nextCity)) == 0 && dist[cur][nextCity] != 0) {
                double nextDist = solve(start, nextCity,
                        curPath + " " + nextCity, curDist + dist[cur][nextCity],
                        visited|1<<nextCity) + dist[cur][nextCity];

                if (minDist > nextDist){
                    minDist = nextDist;
                }
            }
        }

        dp[start][cur][visited] = minDist;

        return minDist;
    }

}
