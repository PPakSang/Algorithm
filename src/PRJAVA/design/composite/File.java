package PRJAVA.design.composite;

public class File implements Component{

    private String name;

    File(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Same Opertaion - " + this.name);
    }

    public String getName() {
        return name;
    }
}
