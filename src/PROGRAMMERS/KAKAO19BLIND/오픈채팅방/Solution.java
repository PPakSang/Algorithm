package PROGRAMMERS.KAKAO19BLIND.오픈채팅방;

import java.util.*;

class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new LinkedList<>();
        List<String> list = new LinkedList<>();

        Map<String, User> userInfo = new HashMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");
            String comd = temp[0];
            String id = temp[1];

            if (comd.equals("Enter")) {
                String name = temp[2];
                userInfo.put(id, new User(name));
            } else if(comd.equals("Leave")) {

            } else if(comd.equals("Change")) {
                String name = temp[2];
                userInfo.put(id, new User(name));
            }

            list.add(comd + " " + id);
        }

        int i = 0;
        for (String str : list) {
            String[] temp = str.split(" ");
            String comd = temp[0];
            String id = temp[1];

            String name = userInfo.get(id).name;
            String str1 = name + "님이 ";
            if (comd.equals("Enter")) {
                str1 += "들어왔습니다.";
            } else if (comd.equals("Leave")) {
                str1 += "나갔습니다.";
            } else {
                continue;
            }
            answer.add(str1);
        }
        return answer.toArray(String[]::new);
    }
}
