package oops.sub;

public class Human {

    int age;
    String name;
    double salary;
    boolean isMarried;
    static int POPULATION = 0;

    public Human() {
    }

    public Human(String name, int age, double salary, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
        POPULATION += 1;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", isMarried=" + isMarried +
                '}';
    }

    static class Test {
        String test = "Testing";

        public String test(String name) {
            return name + " is " + this.test;
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.name());

    }
}

class Chinese extends Human {

    String language;

    public Chinese() {
        super("Chinese", 73, 40000, true);
    }

    public Chinese(String language) {
        this.language = language;
    }
}

class Cantonese extends Human {


    public Cantonese(String name, int age, double salary, boolean married) {
        super(name, age, salary, married);
    }
}