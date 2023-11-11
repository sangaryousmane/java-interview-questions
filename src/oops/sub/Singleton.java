/**
 * Singleton in Java is a design pattern that restricts the instantiation of a class to one object
 * It is useful when we need to ensure that only one instance of a class is created and that it is globally accessible
 */
package oops.sub;

public class Singleton {

    private Singleton(){}

    private static Singleton INSTANCE;

    public static Singleton getInstance(){
        if (INSTANCE == null)
            INSTANCE = new Singleton();

        return INSTANCE;
    }

    public String name(){
        return "Ousmane";
    }
}
