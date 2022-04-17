package BOJ.DivNConq.가장가까운두점;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static List<Point> points;
    static Comparator<Point> compareX = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stringNumber = "100";
        int num = Integer.parseInt(stringNumber);


        n = Integer.parseInt(br.readLine());
        points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            points.add(new Point(x, y));
        }

        points.sort(compareX);

        int answer = findMinDistDNQ(0, n-1);

        System.out.println(answer);
    }

    static int findMinDistBrute(int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            Point p1 = points.get(i);
            for (int j = i+1; j <= end; j++) {
                Point p2 = points.get(j);
                min = Math.min(min, dist(p1, p2));
            }
        }

        return min;
    }

    static int dist(Point o1, Point o2) {
        return (o1.x - o2.x)*(o1.x - o2.x) + (o1.y - o2.y)*(o1.y - o2.y);
    }

    static int findMinDistBetween(int start, int mid, int end, int min) {
        List<Point> possible = new ArrayList<>();

        Point midP = points.get(mid);
        for (int i = start; i <= end; i++) {
            Point p1 = points.get(i);
            if ((p1.x - midP.x)*(p1.x - midP.x) < min) {
                possible.add(p1);
            }
        }

        possible.sort(Comparator.comparing(i -> {
            return i.y;
        }));
        for (int i = 0; i < possible.size()-1; i++) {
            Point p1 = possible.get(i);
            for (int j = i+1; j < possible.size(); j++) {
                Point p2 = possible.get(j);
                if ((p2.y - p1.y)*(p2.y - p1.y) < min) {
                    min = Math.min(dist(p1, p2), min);
                } else {
                    break;
                }
            }
        }
        return min;
    }

    static int findMinDistDNQ(int start, int end) {
        if (end - start < 3) {
            return findMinDistBrute(start, end);
        }
        int interval = end + start;

        int leftMin = findMinDistDNQ(start, interval/2);
        int rightMin = findMinDistDNQ(interval/2 + 1, end);

        int min = Math.min(leftMin, rightMin);

        int midMin = findMinDistBetween(start, interval/2, end, min);

        return Math.min(min, midMin);
    }
}
