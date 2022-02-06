package BOJ.구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long[] nodes;
    static long[] segmentTree;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        nodes = new long[n+1];
        segmentTree = new long[n*4];
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=1; i<n+1; i++) {
            nodes[i] = Long.parseLong(bf.readLine());
        }
        init(1, 1, n);

        List<Long> result = new ArrayList<>();
        for (int i=0; i<m+k; i++) {
            st = new StringTokenizer(bf.readLine());
            int fun =  Integer.parseInt(st.nextToken());
            int n1 =  Integer.parseInt(st.nextToken());
            long n2 =  Long.parseLong(st.nextToken());
            if(fun == 1) {
                long diff = n2 - nodes[n1];
                nodes[n1] = n2;
                update(1, 1, n, n1, diff);
            }
            else {
                result.add(sum(1, 1, n, n1, (int)n2));
            }
        }

        for(long rs : result) {
            System.out.println(rs);
        }

    }

    public static long init(int node, int start, int end) {
        if (start == end) return segmentTree[node] = nodes[start];
        int mid = (start+end)/2;
        return segmentTree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    public static long sum(int node, int start, int end, int from, int to) {
        if (to<start || end<from) return 0;
        if (from<=start && end<=to) return segmentTree[node];
        int mid = (start+end)/2;

        return sum(node*2, start, mid, from, to) + sum(node*2+1, mid+1, end, from, to);
    }

    public static void update(int node, int start, int end, int target, long diff) {
        if (target<start || target>end) return;
        segmentTree[node] += diff;
        if (start==end) return;

        int mid = (start+end)/2;
        update(node*2, start, mid, target, diff);
        update(node*2+1, mid+1, end, target, diff);

    }
}
