package PRJAVA.VO;

import java.util.Objects;

class Reference {
    int age;
    String course;
    String job;

    public Reference(int age, String course, String job) {
        this.age = age;
        this.course = course;
        this.job = job;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final Reference r = (Reference) obj;
        return (this.age == r.age &&
                this.course.equals(r.course) &&
                this.job.equals(r.job));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.course, this.job);
    }
}

public class VO {
    public static void main(String[] args) {
        Reference r1 = new Reference(30, "중", "학생");
        Reference r2 = new Reference(30, "중", "학생");

        System.out.println(r1 == r2);
        System.out.println(r1.equals(r2));
        System.out.println(r1.hashCode() == r2.hashCode());
    }
}