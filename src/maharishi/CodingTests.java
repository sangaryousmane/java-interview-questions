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

}
