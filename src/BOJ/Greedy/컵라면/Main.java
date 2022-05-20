package BOJ.Greedy.컵라면;

import java.util.*;
import java.io.*;

/*
데드라인 별로 컵라면을 받는데 가장 많이 받는 경우

고려를 해야하는 부분이
데드라인 1인데 컵라면 너무 적게 줄 때

즉 데드라인이 빠른 것을 컵라면 고르는 등의 강의실 배정과 같은 선택은 무의미

한번 참으면 다음번에 지금 선택 +1 개 선택가능

1에서 참으면 2짜리 2개
2에서도 참으면 3짜리 3개

그럼 현재 선택가능한 컵라면을 체크하면?

현재 선택할 수 있는 가장 높은 합 +

1 1
2 2 / 2 2
3 2 / 3 3 / 3 3

데드라인 까지 컵라면 가질 수 있다


1일 1개 뽑고
2일 2개 뽑고
3일 3개 뽑고


*/

class Question {
    int deadLine;
    int nums;

    Question(int deadLine, int nums) {
        this.deadLine = deadLine;
        this.nums = nums;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, PriorityQueue<Integer>> point = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            int deadLine = Integer.parseInt(temp[0]);
            int num = Integer.parseInt(temp[1]);

            if (!point.containsKey(deadLine)) {
                point.put(deadLine, new PriorityQueue<>(Comparator.reverseOrder()));
            }

            point.get(deadLine).add(num);
        }

        PriorityQueue<Integer> result = new PriorityQueue<>(Comparator.naturalOrder());

        int answer = 0;

        Integer[] keys = point.keySet().stream().sorted().toArray(Integer[]::new);

        for (Integer key : keys) {
            PriorityQueue<Integer> pq = point.get(key);

            // key = days

            int resSize = result.size();

            //빈 공간 몇칸
            int remain = key - resSize;

            for (int i = 0; i < remain; i++) {
                if (pq.isEmpty()) break;
                result.add(pq.poll());
            }

            if (!pq.isEmpty()) {
                while (true) {
                    if (pq.peek() > result.peek()) {
                        result.poll();
                        result.add(pq.poll());
                    } else break;

                    if (pq.isEmpty()) break;
                }
            }
        }

        while(!result.isEmpty()) {
            answer += result.poll();
        }

        System.out.println(answer);
    }
}
