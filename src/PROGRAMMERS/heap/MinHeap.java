package PROGRAMMERS.heap;

import java.util.*;

public class MinHeap {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int total = 0;


        for (int i : scoville) {
            priorityQueue.add(i);
        }

        while (priorityQueue.peek() < K) {
            total++;

            int a = priorityQueue.poll();
            int b = priorityQueue.poll();

            priorityQueue.add(a+b*2);
        }

        System.out.println(total);
    }
}
