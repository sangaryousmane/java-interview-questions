package recursive;

public class Recursion {


    public static int recursiveMultiplication(int x, int y) {

       if (x <= 0 || y <= 0)
           return 0;

       if (x == 1)
           return y;

       return x + recursiveMultiplication(x, y-1);
    }
}
