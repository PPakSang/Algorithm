package PROGRAMMERS.KAKAO20Intern.수식최대화.순열;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static List<Character> operator = new ArrayList<>();
    static List<Long> nums = new ArrayList<>();


    static char[] operators;
    static List<Character> selected = new ArrayList<>();
    static boolean[] visited = new boolean[3];

    public static void main(String[] args) {
        String str = "100+200*10-100";

        String num = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
                nums.add(Long.parseLong(num));
                operator.add(str.charAt(i));
                num = "";
            } else {
                num += str.charAt(i);
            }
        }

        nums.add(Long.parseLong(num));

        long num1 = nums.get(0);
        long num2 = nums.get(1);
        nums.remove(0);
        nums.remove(1);
        nums.add(0, num1+num2);
        // 이런식으로 더한 걸 추가할 수 있다.

        operators = new char[]{'*', '+', '-'};

        permutate(0);

    }

    static void permutate(int j) {
        if (j == operators.length) {
            selected.forEach(System.out::print);
            System.out.println();
        }

        for (int i = 0; i < operators.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(operators[i]);
                permutate(j+1);
                visited[i] = false;
                selected.remove(selected.size()-1);
            }
        }
    }
}