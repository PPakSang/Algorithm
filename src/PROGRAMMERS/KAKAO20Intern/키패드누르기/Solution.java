package PROGRAMMERS.KAKAO20Intern.키패드누르기;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static Position[] map = new Position[10];
    public static void main(String[] args) {

        map[0] = new Position(3, 1);
        for (int i = 1; i < 10; i++) {
            map[i] = new Position((i-1)/3, (i-1) % 3);
        }

        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Position left = new Position(3, 0);
        Position right = new Position(3, 2);

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                left = map[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                right = map[num];
            } else {
                int state = isClose(left, right, map[num]);
                if (state == 1) {
                    answer.append("L");
                    left = map[num];
                } else if (state == 0) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = map[num];
                    } else {
                        answer.append("R");
                        right = map[num];
                    }
                } else {
                    answer.append("R");
                    right = map[num];
                }
            }
        }


        return answer.toString();
    }

    public static int isClose(Position p1, Position p2, Position dest) {

        int dist1 = Math.abs(dest.x - p1.x) + Math.abs(dest.y - p1.y);
        int dist2 = Math.abs(dest.x - p2.x) + Math.abs(dest.y - p2.y);

        if (dist1 > dist2) {
            return 1;
        } else if (dist1 == dist2) {
            return 0;
        } else {
            return -1;
        }
    }
}
