package PROGRAMMERS.KAKAO22.소수개수구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2_2 {
    public static void main(String[] args) {
        int cnt = 0;
        String num = number(1000000, 3);

        StringBuilder sb = new StringBuilder();
        List<String> numList = new ArrayList<>();
        Arrays.stream(num.split("0")).forEach(i -> {
            if (i.equals("")) {
                return;
            }
            else {
                numList.add(i);
            }
        });

        for (String check : numList) {
            if (isPrime(Long.parseLong(check))) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(Long num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt((double) num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String number(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (!(n == 0)) {
            sb.append(n % k);
            n = n/k;
        }
        sb.reverse();

        return sb.toString();
    }
}
