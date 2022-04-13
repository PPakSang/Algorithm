package PROGRAMMERS.KAKAO21BLIND.메뉴리뉴얼;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
    }

    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb;
    static Integer[] picked = new Integer[11];
    static Stack<String>[] menus = new Stack[11];

    static String[] solution(String[] orders, int[] course) {
        List<String> answer = new LinkedList<>();


        for (int i = 0; i < 11; i++) {
            picked[i] = 0;
            menus[i] = new Stack<>();
        }

        for (String order : orders) {
            for (int num : course) {
                sb = new StringBuilder();
                combination(order, num, 0, 0);
            }
        }

        for (int i = 0; i < 11; i++) {
            if (picked[i] >= 2) {
                while (!menus[i].isEmpty()) {
                    answer.add(menus[i].pop());
                }
            }
        }

        String[] ans = answer.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).toArray(String[]::new);

        return ans;

    }

    static void combination(String order, int courseNum, int num, int start) {
        if (num == courseNum) {
            char[] comb = sb.toString().toCharArray();
            Arrays.sort(comb);
            String sorted = new String(comb);

            Integer cnt = map.get(sorted);
            if (cnt == null) {
                map.put(sorted, 1);
            } else {
                map.put(sorted, map.get(sorted) + 1);
            }
            if (picked[courseNum].equals(map.get(sorted))) {
                menus[courseNum].push(sorted);
            } else if (picked[courseNum] < map.get(sorted)) {
                picked[courseNum] = map.get(sorted);
                menus[courseNum].removeAllElements();
                menus[courseNum].push(sorted);
            }
        }

        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(order, courseNum, num+1, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
