package PRJAVA.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Person {
    int age;

    Person(int age) {
        this.age = age;
    }
}

public class ComparatorTest {


    static Comparator<Person> compareAge = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return -1;
        }
    };

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person a = new Person(20);
        Person b = new Person(12);
        Person c = new Person(33);
        Person d = new Person(30);


        people.add(a);
        people.add(b);
        people.add(c);
        people.add(d);

        people.stream().forEach(i -> {
            System.out.println(i.age);
        });

        System.out.println();
        people.sort(compareAge);

        people.stream().forEach(i -> {
            System.out.println(i.age);
        });
    }
}
