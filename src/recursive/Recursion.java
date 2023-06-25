package recursive;

public class Recursion {


    public static int recursiveMultiplication(int x, int y) {

        if (x <= 0 || y <= 0)
            return 0;

        if (x == 1)
            return y;

        return x + recursiveMultiplication(x, y - 1);
    }

    // TODO: Implement ackerman function - primitive recursive
    public static int ackerman(int m, int n) {
        if (m == 0) // First case
            return n + 1;
        else if (m > 0 && n == 0)  // second case
            return ackerman(m - 1, 1);
        else // third case
            return ackerman(m - 1, ackerman(m, n - 1));
    }

    public static void printHanoi(int start, int end){
        System.out.println("Move " + start + " to " + end);
    }
    public static void hanoi(int n, int start, int end){
        int temp;
        if (n == 1) {
            printHanoi(start, end);
        }
        else {
            temp = 6 - (start + end); // 6 - (1 + 3) = 6 - 4 = 2
            hanoi(n -1, start, temp);
            printHanoi(start, end);
            hanoi(n-1, temp, end);
        }
    }
}
