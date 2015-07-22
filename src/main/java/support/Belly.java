package support;

public class Belly {
    public Belly() { System.out.println("BELLY INITIALISED!!!!!!");}

    public void eat(int cukes) {
        System.out.println("I just EATED " + cukes + " cukes");
    }

    public int waitSomeTime(int hours) {
        return hours + 1;
    }
}
