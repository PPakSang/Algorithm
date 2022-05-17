package PRJAVA.Balloon;

import java.util.*;
import java.io.*;

class Circle {
    double x;
    double y;

    //radius
    double r;
    //start angle
    double s;
    //end angle
    double e;

    Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Angle {
    double s;
    double e;

    public Angle(double s, double e) {
        this.s = s;
        this.e = e;
    }
}
public class Balloon {
    static List<Circle> circles = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        String filePath = Objects.requireNonNull(Balloon.class.getResource("")).getPath();
        BufferedReader br = new BufferedReader(new FileReader(filePath+"input.txt"));

        String temp;

        temp = br.readLine();

        String[] point = temp.split(" ");

        double initX = Double.parseDouble(point[0]);
        double initY = Double.parseDouble(point[1]);

        while((temp = br.readLine()) != null) {
            String[] circle = temp.split(" ");
            circles.add(new Circle(
                    Double.parseDouble(circle[0]) - initX ,
                    Double.parseDouble(circle[1]) - initY,
                    Double.parseDouble(circle[2])));
        }

        //기준점과 원 사이의 두 접점의 각도 구하기
        for (Circle c : circles) {
            double[] angles = getTwoTanAngles(c, new Point(0, 0));
            c.s = angles[0];
            c.e = angles[1];
        }

        circles.sort(new Comparator<Circle>() {
            public int compare(Circle c1, Circle c2) {
                if (c1.e == c2.e) return 0;
                return (c1.e - c2.e) > 0 ? 1 : -1;
            }
        });


        int min = Integer.MAX_VALUE;

        for (int i = 0; i < circles.size(); i++) {
            Circle c = circles.get(i);

            List<Angle> angles = new ArrayList<>();
            for (int j = i; j < circles.size(); j++) {
                Circle tc = circles.get(j);
                angles.add(new Angle(adj(tc.s-c.e), adj(tc.e-c.e)));
            }
            for (int j = 0; j < i; j++) {
                Circle tc = circles.get(j);
                angles.add(new Angle(adj(tc.s-c.e), adj(tc.e-c.e)));
            }

            int cnt = countLays(angles);

            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }

    static int countLays(List<Angle> angles) {
        int cnt = 0;
        double last = -1;

        for (Angle a : angles) {
            if (a.e > a.s) {
                if (a.s > last) {
                    last = a.e;
                    cnt++;
                }
            }
        }
        return cnt+1;
    }


    static Point[] getTanPoint(Circle c, Point std) {
        double sX = std.x;
        double sY = std.y;

        double cX = c.x;
        double cY = c.y;

        double dist = Math.sqrt(Math.pow(sX - cX, 2) + Math.pow(sY - cY, 2));
        double angle = Math.acos(c.r / dist);

        double dir1 = Math.atan2(sY - cY, sX - cX);
        double dir2 = dir1 + angle;
        double dir3 = dir1 - angle;

        double rX1 = cX + c.r * Math.cos(dir2);
        double rY1 = cY + c.r * Math.sin(dir2);
        double rX2 = cX + c.r * Math.cos(dir3);
        double rY2 = cY + c.r * Math.sin(dir3);

        return new Point[]{new Point(rX1, rY1), new Point(rX2, rY2)};
    }

    static double[] getTwoTanAngles(Circle c, Point std) {
        double x = c.x;
        double y = c.y;
        double r = c.r;

        Point[] tanP = getTanPoint(c, std);

        Point p1 = tanP[0];
        Point p2 = tanP[1];

        double s = adj(Math.atan2(p1.y, p1.x)/Math.PI*180);
        double e = adj(Math.atan2(p2.y, p2.x)/Math.PI*180);

        return new double[]{s, e};
    }

    static double adj(double angle) {
        if (angle < 0) angle += 360;

        return angle;
    }

}
