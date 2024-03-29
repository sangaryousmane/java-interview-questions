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

    public static void printHanoi(int start, int end) {
        System.out.println("Move " + start + " to " + end);
    }

    public static void hanoi(int n, int start, int end) {
        int temp;
        if (n == 1)
            printHanoi(start, end);
        else {
            temp = 6 - (start + end); // 6 - (1 + 3) = 6 - 4 = 2
            hanoi(n - 1, start, temp); // move from start to middle
            printHanoi(start, end);     // print step
            hanoi(n - 1, temp, end); // move from middle to end
        }
    }

    public static void sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("Sum is: " + sum);
    }

    public static int sumOfNumbers(int n) {
        int i = 1, sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    public static int sumOfNumbersRecur(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return n + sumOfNumbersRecur(n - 1);
    }

    public static boolean isMember(int[] arr, int target) {
        return checkNumberIfExist(arr, target, 0);
    }

    private static boolean checkNumberIfExist(
            int[] arr, int target, int startIndex) {

        int n = arr.length;
        if (startIndex == n)
            return false;
        if (arr[startIndex] == target)
            return true;
        return checkNumberIfExist(arr, target, startIndex + 1);
    }

    public static int maxElement(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        return Math.max(arr[n - 1], maxElement(arr, n - 1));
    }

    static void print(int n) {
        if (n == 5) {
            System.out.println(5);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }

    static void printReverse(int n) {
        if (n == 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printReverse(n - 1);
    }

    static int factorial(int n) {
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }

    static int sumOfNumber(int n) {
        if (n <= 1) return 1;
        return n + sumOfNumber(n - 1);
    }

    static int fibonacci(int n) {
        // base condition
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sumOfDigitsRecur(int n) {
        if (n == 0) return n;
        return (n % 10) + (sumOfDigitsRecur(n / 10));
    }

    static int productOfNumsRecur(int n) {
        if (n % 10 == n) return n;
        return (n % 10) * productOfNumsRecur(n / 10);
    }

    static int binarySearchRecur(int[] nums, int target, int start, int end) {

        if (start > end)
            return -1;

        int middle = start + (end - start) / 2;
        if (target == nums[middle])
            return middle;
        if (nums[middle] > target)
            return binarySearchRecur(nums, target, start, middle - 1);
        return binarySearchRecur(nums, target, middle + 1, end);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 56, 76};
//        System.out.println(binarySearchRecur(arr, 100, 0, arr.length - 1));

        System.out.println(productOfNumsRecur(325));
    }
}
