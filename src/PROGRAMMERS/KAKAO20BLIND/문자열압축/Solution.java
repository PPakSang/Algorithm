package PROGRAMMERS.KAKAO20BLIND.문자열압축;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aaabaa"));
    }

    public static int solution(String s) {
        int n = s.length();
        int min = s.length();

        for (int i = 1; i <= n/2; i++) {
            // 문자열을 해당 단위로 자를 수 있을 때
            List<String> list = new ArrayList<>();
            // i==나누는 문자열 갯수
            int num = n/i;

            for (int j = 0; j < num; j++) {
                int end = Math.min((j + 1) * i, n);
                list.add(s.substring(j*i, (j+1)*i));
            }

            min = Math.min(min, findSol(n, i, list));
        }

        return min;
    }

    public static int findSol(int n, int cut, List<String> arr) {
        int count = 1;
        String compare = "";

        for (String s : arr) {
            if (!s.equals(compare)) {
                if (count != 0) {
                    int num = Integer.toString(count+1).length();
                    n -= cut*count;
                    n += num;
                    count = 1;
                }

                compare = s;
            } else count++;
        }

        if (count != 1) {
            int num = Integer.toString(count+1).length();
            n -= cut*count;
            n += num;
        }
        return n;
    }
}
