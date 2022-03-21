package PRJAVA.design.composite;

public class Main {

    public static void main(String[] args) {

        Directory dir1 = new Directory("dir1");
        dir1.add(new File("file1"));
        dir1.add(new File("file2"));
        dir1.add(new File("file3"));

        Directory dir2 = new Directory("dir2");
        dir2.add(dir1);

        dir2.operation();
    }
}
