package PROGRAMMERS.KAKAO21Intern.표편집;

import java.util.Stack;

public class Main {


    public static void main(String[] args) {

    }

    public static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();

        int maxTableIndex = n - 1;
        Stack<Integer> history = new Stack<>();

        for (String str : cmd) {
            char c = str.charAt(0);
            int num;

            switch (c) {
                case 'U':
                    num = Integer.parseInt(str.split(" ")[1]);
                    k = k - num;
                    break;

                case 'D':
                    num = Integer.parseInt(str.split(" ")[1]);
                    k = k + num;
                    break;

                case 'C':
                    history.push(k);

                    if (k == maxTableIndex) {
                        k--;
                    }

                    maxTableIndex--;
                    break;
                case 'Z':
                    int lastNum = history.pop();

                    if (lastNum > k) {
                        k++;
                    }

                    maxTableIndex++;
                    break;
            }
        }


        for (int i = 0; i < maxTableIndex + 1; i++) {
            answer.append("O");
        }

        while (history.isEmpty()) {
            answer.insert(history.pop(), "X");
        }

        return answer.toString();
    }
}
