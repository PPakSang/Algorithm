package PRJAVA.DI.순환참조;

class OnePerson {
    private final TwoPerson two;

    OnePerson(TwoPerson two) {
        this.two = two;
    }

}
class TwoPerson {
    private final OnePerson one;

    TwoPerson(OnePerson one) {
        this.one = one;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
