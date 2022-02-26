package PROGRAMMERS.KAKAO22.신고결과받기;

import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, HashSet<String>> list = new HashMap<>(); //신고당한사람 - 신고한사람
        Map<String, Integer> result = new HashMap<>(); // 신고한사람 - 알람횟수

        int size = 0;

        for (String id : id_list) {
            result.put(id, 0);
            size++;
        }

        int[] answer = new int[size];

        for (String rep : report) {
            StringTokenizer st = new StringTokenizer(rep);
            String a = st.nextToken(); //신고한사람
            String b = st.nextToken(); //신고당한사람

            try {
                list.get(b).add(a);
            }catch (Exception e) {
                list.put(b, new HashSet<>());
                list.get(b).add(a);
            }


        }
        for (String key : list.keySet()) {
            HashSet<String> reported = list.get(key);
            if (reported.size() >=k) {
                reported.stream().forEach(i -> {
                    Integer alarm = result.get(i);
                    alarm++;
                    result.put(i, alarm);
                });
            }
        }

        int temp = 0;
        for (String id : id_list) {
            answer[temp] = result.get(id);
            temp++;
        }
        return null;
    }
}
