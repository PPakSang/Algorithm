package PRJAVA.comparator;

import java.util.ArrayList;
import java.util.List;

class Animal implements Comparable<Animal>{
    int age;

    Animal(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Animal o) {

        return this.age - o.age;
    }
}

public class ComparableTest {
    public static void main(String[] args) {
        List<Animal> people = new ArrayList<>();
        Animal a = new Animal(20);
        Animal b = new Animal(12);
        Animal c = new Animal(33);
        Animal d = new Animal(30);

        System.out.println(a.compareTo(b));
    }
}
