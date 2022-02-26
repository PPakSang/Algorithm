package PROGRAMMERS.KAKAO22.소수개수구하기;

public class Solution2 {
    public static void main(String[] args) {
        int cnt = 0;
        String num = number(1000000, 3);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            if (ch == '0') {
                if (!sb.toString().equals("")) {
                    if (isPrime(Long.parseLong(sb.toString()))) cnt++;
                    sb = new StringBuilder();
                }
            }
            else {
                sb.append(ch);
                if (i==num.length()-1) {
                    if (!sb.toString().equals("")) {
                        if (isPrime(Long.parseLong(sb.toString()))) cnt++;
                        sb = new StringBuilder();
                    }
                }
            }
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
