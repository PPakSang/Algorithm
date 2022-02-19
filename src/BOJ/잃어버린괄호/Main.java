package BOJ.잃어버린괄호;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-+", true);

        int total = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<String> operators = new Stack<>();

        operators.push("+");

        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.equals("+") || next.equals("-")) {
                operators.push(next);
            }
            else {
                nums.push(Integer.parseInt(next));
            }
        }
        int temp = 0;

        while (!nums.isEmpty()) {
            int num = nums.pop();
            String operator = operators.pop();
            temp += num;
            if (operator.equals("-")) {
                total -= temp;
                temp = 0;
            }
        }

        System.out.println(total+temp);
    }
}
