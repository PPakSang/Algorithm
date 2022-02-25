package BOJ.DFSBFS.MooTube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int q;

    static List<Node>[] video;

    public static class Node {
        public int index;
        public int usado;

        Node (int index, int usado) {
            this.index = index;
            this.usado = usado;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        video = new ArrayList[n+1];

        for (int i=0; i<n+1; i++) {
            video[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            video[p].add(new Node(q, r));
            video[q].add(new Node(p, r));
        }

        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int watchingVideo = Integer.parseInt(st.nextToken());

            recommend(k, watchingVideo);
        }
    }

    static void recommend(int k, int watchingVideo) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int count = 0;

        q.add(watchingVideo);
        visited[watchingVideo] = true;
        while (!q.isEmpty()) {
            int searchNode = q.poll();

            for (Node connNode : video[searchNode]) {
                int index = connNode.index;
                int usado = connNode.usado;

                if (!visited[index] && usado>=k) {
                    count++;
                    q.add(index);
                    visited[index] = true;
                }
            }
        }

        System.out.println(count);
    }


}
