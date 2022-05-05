package PROGRAMMERS.KAKAO21BLIND.메뉴리뉴얼.복습;

import java.util.*;

class Solution {
    Map<String, Integer> choice = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (String order : orders) {
            for (int i = 2; i <= order.length(); i++) {
                comb(i, 0, "", order);
            }
        }

        for (int num : course) {
            int max = Integer.MIN_VALUE;
            List<String> temp = new LinkedList<>();
            for (String key : choice.keySet()) {
                int value = choice.get(key);
                if ((value > 1) && (key.length() == num) && (value >= max)) {
                    if (max < value) {
                        temp = new LinkedList<>();
                    }
                    temp.add(key);
                    max = value;
                }
            }

            for (String t : temp) {
                answer.add(t);
            }
        }


        return answer.stream().sorted().toArray(String[]::new);
    }

    void comb(int num, int start, String cb, String order) {
        if (cb.length() == num) {
            char[] temp = cb.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            choice.put(key, choice.getOrDefault(key, 0)+1);
            return;
        }


        for (int i = start; i < order.length(); i++) {
            comb(num, i+1, cb+order.charAt(i), order);
        }

    }
}

