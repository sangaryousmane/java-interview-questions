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
        if (n == 1)
            printHanoi(start, end);
        else {
            temp = 6 - (start + end); // 6 - (1 + 3) = 6 - 4 = 2
            hanoi(n -1, start, temp); // move from start to middle
            printHanoi(start, end);     // print step
            hanoi(n-1, temp, end); // move from middle to end
        }
    }

    public static void sumOfDigits(int n){
        int sum = 0;
        while (n  > 0){
            int digit = n  % 10;
            sum +=digit;
            n /= 10;
        }
        System.out.println("Sum is: "+ sum);
    }

    public static int sumOfNumbers(int n){
        int i = 1, sum = 0;

        while (i <= n){
            sum += i;
            i++;
        }
        return sum;
    }
    public static int sumOfNumbersRecur(int n){
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return n + sumOfNumbersRecur(n - 1);
    }

    public static boolean isMember(int[]arr, int target){
       return checkNumberIfExist(arr, target, 0);
    }

    private static boolean checkNumberIfExist(
            int[] arr, int target, int startIndex){
        int n = arr.length;
        if (startIndex==n)
            return false;
        if (arr[startIndex] == target)
            return true;
        return checkNumberIfExist(arr, target, startIndex+1);
    }
}
