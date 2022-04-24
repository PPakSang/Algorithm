package PRJAVA.tree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

class Sample {
    int age;
    int career;

    Sample(int age, int career) {
        this.age = age;
        this.career = career;
    }
}

public class Trees {
    static Comparator<Sample> compareSample = new Comparator<>() {

        @Override
        public int compare(Sample o1, Sample o2) {
            if (o1.age == o2.age) {
                return o1.career - o2.career;
            }
            return o1.age - o2.age;
        }
    };
    public static void main(String[] args) {
        Random random = new Random();
        TreeSet<Sample> set = new TreeSet<>(compareSample);
        TreeMap<String, String> map = new TreeMap<>();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Sample sample = new Sample(random.nextInt(99)+1, random.nextInt(99)+1);
            set.add(sample);
        });
        Sample[] aa = new Sample[10];
        Integer[] bb = new Integer[2];
        Arrays.stream(bb).sorted();
        IntStream.of();

        System.out.println(set.size());
        for (Sample s : set) {
            System.out.printf("%d : %d\n", s.age, s.career);
        }
    }
}
