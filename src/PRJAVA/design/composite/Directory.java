package PRJAVA.design.composite;

import java.util.ArrayList;
import java.util.List;


public class Directory implements Component{

    private String name;
    List<Component> components = new ArrayList<>();


    Directory(String name) {
        this.name = name;
    }

    @Override
    public void operation() {

        System.out.println("Same operation - " + this.name);
        components.stream().forEach(child -> {
            child.operation();
        });
    }

    public void add(Component component) {

        components.add(component);
    }

    public void remove(Component component) {

        components.remove(component);
    }

    public void getChild() {

        components.stream().forEach(child -> {
            System.out.print(child.getName());
        });
    }

    public String getName() {

        return name;
    }
}
