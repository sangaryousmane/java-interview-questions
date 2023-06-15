// https://compro.miu.edu/sample-test/
package maharishi;

public class CodingTests {

    // Find the smallest element in an odd number array
    public static int smallestOfOddNumArray(int[] nums){
        // {3, 2, 1, 4, 5}
        // Check if array is not null or length == 0 return 0
        // Check if the array is an odd number array
        // find the middle element or midpoint
        // for all element of the array
        // if element at each index is greater > middle index and
        // middle < at each index
        // return 1, 0 otherwise.

        if (nums ==null || nums.length == 0)
            return 0;

        if (nums.length % 2 ==0)
            return 0;

        int middleIndex = nums.length / 2;
        int middleElement = nums[middleIndex];

        for (int i = 0; i < nums.length; i++){
            if (i != middleIndex && middleElement >= nums[i] )
                return 0;
        }
        return 1;
    }

    // Find the difference of sum of even and odd numbers in an array
    public static int sumOfEvenOdd(int[] nums){
        // Check if the array is null, return 0
        // Get the sum of even and odd
        // return the difference between them
        int i = 0;
        int sumOfEven = 0, sumOfOdd = 0;
        if (nums == null || nums.length == 0)
            return 0;

        while (i < nums.length){
            if (nums[i] % 2 == 0)
                sumOfEven +=nums[i];
            else
                sumOfOdd +=nums[i];
            i++;
        }
        // odd = X, even = Y so, X - Y
        return sumOfOdd - sumOfEven;
    }

    // Find the set of character arrays that contains length of characters
    // starting at the start index (zero-based)
    public static char[] startToLength(char[] letters, int start, int length){

        if (length < 0 || start < 0 ||
                start + length-1 >= letters.length){
            return null;
        }
        char[] sub=new char[length];
        int right = start + length; // apply sliding window
        for (int i = start; i < right; i++){
            sub[i - start] = letters[i];
        }
        return sub;
    }
}
