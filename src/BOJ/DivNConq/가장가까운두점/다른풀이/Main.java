package BOJ.DivNConq.가장가까운두점.다른풀이;

import java.io.*;
import java.util.*;

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
    static Point[] points;
    static Comparator<Point> compareX = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    };

    static Comparator<Point> compareY = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        }
    };

    public static void main(String[] args) throws IOException {
        String filePath = Main.class.getResource("").getPath();
        BufferedReader br = new BufferedReader(new FileReader(filePath + "input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(filePath + "output.txt"));

        n = Integer.parseInt(br.readLine());
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, compareX);

        TreeSet<Point> set = new TreeSet<Point>(compareY);


        set.add(points[0]);
        set.add(points[1]);

        int min = dist(points[0], points[1]);

        int checkX = 0;

        for (int i = 2; i < n; i++) {
            Point target = points[i];

            while (checkX < i) {
                int distX = target.x - points[checkX].x;

                if (distX*distX > min) {
                    set.remove(points[checkX]);
                    checkX++;
                } else {
                    break;
                }
            }

            int sqrtMin = (int)Math.sqrt(min) + 1;

            TreeSet<Point> subset = (TreeSet<Point>) set.subSet(new Point(-100000, target.y - sqrtMin),
                    new Point(100000, target.y + sqrtMin));

            for (Point p : subset) {
                min = Math.min(min, dist(target, p));
            }

            set.add(target);
        }

        pw.printf("%d\n", min);

        br.close();
        pw.close();
    }

    static int dist(Point o1, Point o2) {
        return (o1.x - o2.x)*(o1.x - o2.x) + (o1.y - o2.y)*(o1.y - o2.y);
    }
}
