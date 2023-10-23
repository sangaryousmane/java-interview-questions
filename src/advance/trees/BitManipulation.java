package advance.trees;

public class BitManipulation {

    public static void main(String[] args) {
        int num = rightShift1(4, 3);
        int []nums = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(findTheIthBit(14));
    }

    private static int leftShift1(int num1, int num2) {
        return num1 << num2; // num1 * 2^num2
    }

    private static int leftShift2(int num1) {
        return num1 << 1; // 2*num1
    }

    private static int rightShift1(int num1, int num2) {
        return num1 >> num2; // num1 / 2^num2
    }

    // Given a number, find if it is odd or even
    public static String oddEven(int number) {
        return (number & 1) == 1 ? "ODD NUMBER" : "EVEN NUMBER";
    }

    // Find the only unique element in the array O(n)
    public static int uniqueDigit(int[] nums) {
        int unique = 0;
        for (int n : nums) {
            unique ^= n;
        }
        return unique;
    }

    // Find the ith bit of a number
    public static int findTheIthBit(int number){
        return number & ((1 << number -1));
    }

    // Set ith bit

    // Find the position of the right most set bit

}
