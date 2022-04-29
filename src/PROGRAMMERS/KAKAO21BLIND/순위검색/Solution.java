package PROGRAMMERS.KAKAO21BLIND.순위검색;

import java.util.*;

class Solution {

    List<String> qList;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>>  user = new HashMap<>();

        String[] lang = new String[]{"cpp", "java", "python"};
        String[] job = new String[]{"backend", "frontend"};
        String[] level = new String[]{"junior", "senior"};
        String[] food = new String[]{"chicken", "pizza"};

        for (String s : info) {
            String[] temp = s.split(" ");
            String filter = temp[0] + temp[1] + temp[2] + temp[3];
            Integer score = Integer.parseInt(temp[4]);


            if (user.get(filter) == null) {
                List<Integer> scores = new ArrayList<>();
                scores.add(score);
                user.put(filter, scores);
            } else {
                user.get(filter).add(score);
            }
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll("and ", "").split(" ");
            qList = new ArrayList<>();
            qList.add("");


            if (q[0].equals("-")) {
                addQ(lang);
            }else {
                addQ(new String[]{q[0]});
            }

            if (q[1].equals("-")) {
                addQ(job);
            }else {
                addQ(new String[]{q[1]});
            }

            if (q[2].equals("-")) {
                addQ(level);
            }   else {
                addQ(new String[]{q[2]});
            }

            if (q[3].equals("-")) {
                addQ(food);
            }else {
                addQ(new String[]{q[3]});
            }

            int fs = Integer.parseInt(q[4]);
            int total = 0;
            for (String real : qList) {
                List<Integer> sl = user.get(real);
                if (sl != null) {
                    for (Integer us : user.get(real)) {
                        if (us >= fs) total++;
                    }
                }

            }

            answer[i] = total;
        }



        return answer;
    }

    void addQ(String[] q) {
        List<String> newList = new ArrayList<>();

        for (String s : q) {
            for (String ss : qList) {
                newList.add(ss + s);
            }
        }

        qList = newList;
    }

}
