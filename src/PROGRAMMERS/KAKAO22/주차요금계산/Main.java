package PROGRAMMERS.KAKAO22.주차요금계산;

import java.util.*;

public class Main {

    static int basicTime;
    static int basicFee;
    static int mTime;
    static int mFee;

    public static void main(String[] args) {
        int[] result = solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        );

        for (int r : result) {
            System.out.println(r);
        }


    }

    public static int[] solution(int[] fees, String[] records) {

        basicTime = fees[0];
        basicFee = fees[1];
        mTime = fees[2];
        mFee = fees[3];

        Map<String, Integer[]> cost = new HashMap<>(); //차량번호 - 요금

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNum = st.nextToken();
            int inOut = st.nextToken().equals("IN") ? 1 : 0;

            if (inOut == 1) {
                //첫 등록 시키기
                try {
                    Integer[] info = cost.get(carNum);
                    info[0] = timeToInt(time);
                    info[2] = 1;
                    cost.put(carNum, info);
                }catch(Exception e) {
                    cost.put(carNum, new Integer[]{timeToInt(time), 0, 1, 0}); //Integer[최근 입차 시간, 누적 시간, in/out, 총 요금]
                }
            }
            else {
                Integer[] info = cost.get(carNum);
                info[1] += timeToInt(time) - info[0];
                info[2] = 0;

                cost.put(carNum, info);
            }
        }
        List<String> carNums = new ArrayList<>();
        for (String carNum : cost.keySet()) {
            // 아직 출차 안했다면
            if (cost.get(carNum)[2] == 1) {
                Integer[] info = cost.get(carNum);
                int last = timeToInt("23:59") - info[0];
                int totalTime = info[1] + last;

                info[3] += calcFee(totalTime);
                info[2] = 0;

                cost.put(carNum, info);
            }
            else {
                Integer[] info = cost.get(carNum);
                info[3] = calcFee(info[1]);
                cost.put(carNum, info);
            }

            carNums.add(carNum);
        }

        carNums.sort(Comparator.naturalOrder());
        int nums = carNums.size();
        int[] result = new int[nums];

        for (int i=0; i<nums; i++) {
            String carNum = carNums.get(i);
            result[i] = cost.get(carNum)[3];
        }

        return result;
    }

    public static int timeToInt(String time) {
        String[] timeInfo = time.split(":");

        return Integer.parseInt(timeInfo[0])*60 + Integer.parseInt(timeInfo[1]);
    }

    public static int calcFee(int totalTime) {

        if (totalTime <= basicTime) {
            return basicFee;
        }
        else {
            int exTime = totalTime - basicTime;

            return basicFee + (int)Math.ceil(exTime/(double)mTime)*mFee;
        }
    }
}
