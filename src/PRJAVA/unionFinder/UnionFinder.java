package PRJAVA.unionFinder;

public class UnionFinder {
    static int[] group;
    public static void main(String[] args) {
        group = new int[10];

        for (int i = 0; i < 10; i++) {
            group[i] = i;
        }

        union(1, 2);
        union(2, 3);

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d - %d\n", i, group[i]);
        }
    }

    static int find(int index) {
        if (group[index] == index) {
            return index;
        } else {
            // group[index] = 를 하는 이유는 나의 부모 그룹넘버가 바뀌었을 수도 있기 때문
            return group[index] = find(group[index]);
        }
    }

    static void union(int x, int y) {
        int x1 = find(x);
        int x2 = find(y);

        if (x1 < x2) {
            group[x2] = x1;
        } else {
            group[x1] = x2;
        }
    }
}
