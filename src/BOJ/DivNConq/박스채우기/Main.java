package BOJ.DivNConq.박스채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int[] arr = new int[20];
    static int[] num;
    static boolean isBox = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
            num[i] = (int)Math.pow(2, (double)i);
        }

        insertCube(l, w, h);
        if (isBox) {
            System.out.println(cnt);
        }
        else {
            System.out.println(-1);
        }
        br.close();

    }

    static void insertCube(int boxl, int boxw, int boxh) {
        int min = Math.min(boxl,Math.min(boxh,boxw));
        //더이상 넣을 블럭이 없다.
        if (boxl<=0 || boxw<=0 || boxh<=0) {
            return;
        }
        int nextCube=0;
        int idx=0;
        for (int i=19; i>=0; i--) {
            if (arr[i]>0 && min >= num[i]) {
                nextCube = num[i];
                idx = i;
                break;
            }
        }
        if (nextCube == 0) {
            isBox = false;
            return;
        }
        //집어넣을 가장 큰 블럭



        //가장 큰 블럭으로 못 넣으면 그 다음 크기 블럭을 넣어본다

        cnt++;
        arr[idx]--;
        //넣을 수 있다
        insertCube(boxl - nextCube, boxw, boxh);
        insertCube(nextCube, boxw - nextCube, boxh);
        insertCube(nextCube, nextCube, boxh - nextCube);

    }
}
