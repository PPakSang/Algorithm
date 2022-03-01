package PROGRAMMERS.KAKAO21Intern.숫자문자열과영단어;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        int result = solution("one4seven");

        System.out.println(result);
    }

    public static int solution(String s) {
        Map<String, Integer> wordToNum = new HashMap<>();
        wordToNum.put("zero", 0);
        wordToNum.put("one", 1);
        wordToNum.put("two", 2);
        wordToNum.put("three", 3);
        wordToNum.put("four", 4);
        wordToNum.put("five", 5);
        wordToNum.put("six", 6);
        wordToNum.put("seven", 7);
        wordToNum.put("eight", 8);
        wordToNum.put("nine", 9);



        StringTokenizer st = new StringTokenizer(s, "0123456789", true);

        int result = 0;

        while(st.hasMoreTokens()) {
            String nT = st.nextToken();
            if (nT.length() == 1) {
                result = result*10 + Integer.parseInt(nT);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<nT.length(); i++) {
                 sb.append(nT.charAt(i));
                 try {
                     int nextNum = wordToNum.get(sb.toString());
                     result = result*10 + nextNum;
                     sb = new StringBuilder();
                 }catch(Exception e) {
                 }
            }

        }

        return result;
    }
}
