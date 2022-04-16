package PRJAVA.convexHull;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int color; // 0 : red, 1 : blue

    public Point(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class ConvexHull {
    static Comparator<Point> compareY = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.y - o2.y;
        }
    };

    static int n;
    static Point root;

    static Comparator<Point> compareCCW = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return ccw(root, o1, o2);
        }
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            points.add(new Point(x, y, 0));
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            points.add(new Point(x, y, 1));
        }

        points.sort(compareY);

        findLines(points);
    }

    static int ccw(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
    }

    static void findLines(List<Point> points) {
        if (points.isEmpty()) return;

        Point p = points.get(0);
        List<Point> sub = points.subList(1, points.size());

        root = p;
        sub.sort(compareCCW);

        int cnt = 0;
        int flag = p.color == 0 ? -1 : 1;

        List<Point> nxt = new LinkedList<>();
        for (Point point : sub) {
            cnt += point.color == 0 ? 1 : -1;

            if (cnt == flag) {
                System.out.printf("%d %d, %d %d\n", p.x, p.y, point.x, point.y);
                flag = Integer.MIN_VALUE;
                findLines(nxt);
                nxt.clear();
            } else {
                nxt.add(point);
            }
        }

        findLines(nxt);
    }
}
