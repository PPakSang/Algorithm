package PROGRAMMERS.KAKAO20Intern.수식최대화;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Solution {

        static long answer = Long.MIN_VALUE;
        static  boolean[] check;
        static List<String> operator;
        static Stack<String> stack = new Stack<>();
        static List<String> q;
        static String exp;



        public static long solution(String expression) {
            exp = expression;
            operator = new ArrayList<>();
            if (expression.contains("*")) operator.add("*");
            if (expression.contains("+")) operator.add("+");
            if (expression.contains("-")) operator.add("-");

            check = new boolean[operator.size()];

            calc(0);

            return answer;
        }

        static void  calc(int i) {
                if (i == operator.size()) {
                    q = new LinkedList<>(stack);
                    answer = Math.max(answer, Math.abs(solve(exp, 0)));
                }

                for (int j = 0; j < operator.size(); j++) {
                    if (!check[j]) {
                        check[j] = true;
                        stack.push(operator.get(j));
                        calc(i+1);
                        check[j] = false;
                        stack.pop();
                    }
                }
            }

        static long  solve(String str,int i) {
                if (i == q.size()) {
                    return Long.parseLong(str);
                }

                String op = q.get(i);
                String[] temp;

                if (op.equals("*")) temp = str.split("\\*");
                else if (op.equals("+")) temp = str.split("\\+");
                else temp = str.split(op);

                long f = solve(temp[0], i+1);

                for (int j = 1; j < temp.length; j++) {
                    if (op.equals("*")) {
                        f *= solve(temp[j], i+1);
                    } else if(op.equals("+")) {
                        f += solve(temp[j], i+1);
                    } else {
                        f -= solve(temp[j], i+1);
                    }
                }

                return f;
            }
}
