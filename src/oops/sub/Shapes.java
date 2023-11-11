package oops.sub;

public class Shapes {

    void area(){
        System.out.println("I am an area");
    }

    void circle(){
        System.out.println("I am a circle");
    }

    public static void main(String[] args) {
        Shapes shape=new Shapes();
        Triangle triangle=new Triangle();
        Square square=new Square();

        System.out.println(triangle.size());
    }
}

class Triangle extends Shapes{
    double h, base;

    double size(){
        return 0.5 * h * base;
    }

    // method overloading
    void size(int size){
        System.out.println("Hello, this is a size " + size);
    }

    @Override
    void area() {
        double area = this.h * this.base * Math.PI;
        System.out.println("I am equal to: "+ area);
    }

    void talk(){
        System.out.println("I am a triangle");
    }

    {
        System.out.println("I ama n instance initializer bloc");
    }
}

class Square extends Shapes{

    double w, h;

    double side(){
        return w * h;
    }
}
