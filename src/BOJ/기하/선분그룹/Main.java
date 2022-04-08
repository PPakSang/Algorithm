package BOJ.기하.선분그룹;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Line {
    double x1;
    double y1;
    double x2;
    double y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {

    static int n;
    static int[] parent;
    static Line[] lines;

    static final double MAX = 5000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        lines = new Line[n];



        for (int i = 0; i < n; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            lines[i] = new Line(x1, y1, x2, y2);
        }

        for (int i = 0; i < n; i++) {
            Line l1 = lines[i];
            for (int j = i; j < n; j++) {
                Line l2 = lines[j];

                double res = crossXPoint(l1, l2);

                if (res == MAX+1) {

                    if (((l1.x1 - l1.x2) == 0) && ((l2.x1 - l2.x2) == 0)) {

                        if (l1.x1 != l2.x1) {
                            continue;
                        }

                        if ((l1.y1 > l2.y1 && l1.y1 > l2.y2) && (l1.y2 > l2.y1 && l1.y2 > l2.y2)
                        || (l2.y1 > l1.y1 && l2.y1 > l1.y2) && (l2.y2 > l1.y1 && l2.y2 > l1.y2)) {
                            continue;
                        }

                        union(i, j);

                        continue;
                    }

                    // x = a 형태가 아닌 경우
                    double m1 = (l1.y2 - l1.y1) / (l1.x2 - l1.x1);
                    double m2 = (l2.y2 - l2.y1) / (l2.x2 - l2.x1);

                    double n1 = -m1 * l1.x1 + l1.y1;
                    double n2 = -m2 * l2.x1 + l2.y1;

                    // 두 직선이 평행
                    if (n1 != n2) {
                        continue;
                    }

                    // 두 직선이 일치하지만, 각각의 선분이 만나지는 않는 경우

                    // y = a인 형태를 고려해야 함.
                    if ((l1.x1 > l2.x1 && l1.x1 > l2.x2 && l1.x2 > l2.x1 && l1.x2 > l2.x2)
                            || (l2.x1 > l1.x1 && l2.x1 > l1.x2 && l2.x2 > l1.x1 && l2.x2 > l1.x2)) {
                        continue;
                    }


                    if ((l1.y1 > l2.y1 && l1.y1 > l2.y2 && l1.y2 > l2.y1 && l1.y2 > l2.y2)
                            || (l2.y1 > l1.y1 && l2.y1 > l1.y2 && l2.y2 > l1.y1 && l2.y2 > l1.y2)) {
                        continue;
                    }

                    union(i, j);
                } else {
                    double minX1 = Math.min(l1.x1, l1.x2);
                    double maxX1 = Math.max(l1.x1, l1.x2);

                    double minX2 = Math.min(l2.x1, l2.x2);
                    double maxX2 = Math.max(l2.x1, l2.x2);

                    if ((minX1<=res && res<=maxX1) && (minX2<=res && res<=maxX2)) {
                        res = crossYPoint(l1, l2);

                        double minY1 = Math.min(l1.y1, l1.y2);
                        double maxY1 = Math.max(l1.y1, l1.y2);

                        double minY2 = Math.min(l2.y1, l2.y2);
                        double maxY2 = Math.max(l2.y1, l2.y2);

                        if ((minY1<=res && res<=maxY1) && (minY2<=res && res<=maxY2)) {
                            union(i, j);
                        }

                    }

                }
            }
        }

        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            cnt[find(i)]++;
        }

        int max = 0;
        int group = 0;

        for (int i = 0; i < n; i++) {
            if (cnt[i] > 0) group++;

            max = Math.max(max, cnt[i]);
        }

        System.out.println(group);
        System.out.println(max);
    }

    static double crossXPoint(Line l1, Line l2) {
        if (((l1.x1 - l1.x2)*(l2.y1-l2.y2) - (l1.y1-l1.y2)*(l2.x1-l2.x2)) == 0) {
            return MAX+1;
        }

        double denominator = ((l1.x1 * l1.y2 - l1.y1 * l1.x2) * (l2.x1 - l2.x2))
                - ((l1.x1 - l1.x2) * (l2.x1 * l2.y2 - l2.y1 * l2.x2));
        double numerator = ((l1.x1 - l1.x2) * (l2.y1 - l2.y2)) - ((l1.y1 - l1.y2) * (l2.x1 - l2.x2));

        return denominator / numerator;
    }

    static double crossYPoint(Line l1, Line l2) {
        if (((l1.x1 - l1.x2)*(l2.y1-l2.y2) - (l1.y1-l1.y2)*(l2.x1-l2.x2)) == 0) {
            return MAX+1;
        }

        double denominator = ((l1.x1 * l1.y2 - l1.y1 * l1.x2) * (l2.y1 - l2.y2))
                - ((l1.y1 - l1.y2) * (l2.x1 * l2.y2 - l2.y1 * l2.x2));
        double numerator = ((l1.x1 - l1.x2) * (l2.y1 - l2.y2)) - ((l1.y1 - l1.y2) * (l2.x1 - l2.x2));

        return denominator / numerator;
    }

//    Union Finder........

    static int find (int idx) {
        if (idx == parent[idx]) {
            return idx;
        } else {
            return parent[idx] = find(parent[idx]);
        }
    }

    static void union(int x, int y) {
        int x1 = find(x);
        int x2 = find(y);

        if (x1 != x2) {
            if (x1 < x2) {
                parent[x2] = x1;
            } else {
                parent[x1] = x2;
            }
        }

    }

}
