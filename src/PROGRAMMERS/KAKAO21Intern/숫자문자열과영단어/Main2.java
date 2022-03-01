package PROGRAMMERS.KAKAO21Intern.숫자문자열과영단어;

import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) {
        int result = solution("one2threefour");

        System.out.println(result);
    }

    public static int solution(String s) {

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i=0; i<arr.length; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
