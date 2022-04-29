package PROGRAMMERS.KAKAO21BLIND.순위검색.개선;

import java.util.*;

public class Solution {
    Map<String,List<Integer>> user = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String i : info) {
            String[] infoList = i.split(" ");

            comb(0, "", infoList);
        }

        for (String key : user.keySet()) {
            user.get(key).sort(Comparator.naturalOrder());
        }

        int i = 0;
        for (String q : query) {
            String[] temp = q.replaceAll("and ","").split(" ");
            String key = temp[0] + temp[1] + temp[2] + temp[3];
            Integer score = Integer.parseInt(temp[4]);
            if (user.containsKey(key))
                answer[i++] = binarySerach(user.get(key), score);
            else answer[i++] = 0;
        }

        return answer;
    }

    void comb(int i, String s, String[] info) {
        if (i == 4) {
            if(user.containsKey(s)) {
                user.get(s).add(Integer.parseInt(info[4]));
            } else {
                List<Integer> scores = new ArrayList<>();
                scores.add(Integer.parseInt(info[4]));
                user.put(s, scores);
            }

            return;
        }

        comb(i+1, s+"-", info);
        comb(i+1, s+info[i], info);
    }


    int binarySerach(List<Integer> arr, int score) {
        int start = 0;
        int end = arr.size();
        int mid = end/2;

        while (start < end) {
            if (arr.get(mid)>=score) {
                end = mid;
            } else {
                start = mid+1;
            }
            mid = (start+end)/2;
        }

        return arr.size() - end;
    }
}
