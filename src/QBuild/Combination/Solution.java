package QBuild.Combination;

import java.util.*;

public class Solution {

    static List<String> storage = new ArrayList<>();

    // list C target
    static void solveCombination(int start, int cnt, int target, List<?> list, String result) {
        if (cnt == target) {
            // Combination Complete
            storage.add(result);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            solveCombination(i+1, cnt+1, target, list, result + list.get(i));
        }
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        solveCombination(0, 0, 2, list, "");

        for (String s : storage) System.out.println(s);
    }
}
