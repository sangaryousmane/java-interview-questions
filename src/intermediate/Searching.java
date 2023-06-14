package intermediate;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Searching {


    // https://leetcode.com/problems/sqrtx/description/
    public static int mySqrt(int n) {
        int start = 1, end = n;

        if (n == 0 || n == 1) {
            return n;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (n / mid == mid)
                return mid;
            else if (n / mid < mid)
                end = mid - 1;
            else if (n / mid > mid)
                start = mid + 1;
        }
        return end;
    }

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSum(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        int[] ans=new int[2];
//
//        while (start < end){
//            int sum = nums[start] + nums[end];
//
//            if (sum == target){
//                ans[0] = start+1;
//                ans[1] = end + 1;
//                break;
//            }
//            else if (sum > target)
//                end--;
//            else
//                start++;
//        }
//        return ans;
        int start = 0, end = nums.length - 1;

        while (nums[start] + nums[end] != target) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{start + 1, end + 1};
    }

    // https://leetcode.com/problems/arranging-coins/
    public static int arrangeCoins(int n) {
//        int i = 1;
//
//        while (n > 0) {
//            i++;
//            n -= i;
//        }
//        return i - 1;

        long left = 0, end = n;
        long current, middle;

        while (left <= end) {
            middle = left + (end - left);
            current = middle * (middle + 1) / 2;

            if (n == current)
                return (int) current;
            else if (n < current) {
                end = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return (int) end;
    }


    // https://leetcode.com/problems/binary-search/
    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // Order agnostic binary Search
    public static int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        // It is ascending if the start is less than the end
        boolean isAsc = nums[start] < nums[end];

        while (start <= end) {
            // To avoid int overflow
            int mid = start + (end - start) / 2;

            if (target == nums[mid])
                return mid;

            if (isAsc) {
                if (target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target > nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    // Find if a given target is found in an array, return -1 if not found
    // Use Linear search with the time complexity of: O(n)
    public static int linearSearch(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // Check if a letter is found within a string
    public static boolean linearSearchString(String str, char target) {
        if (str.length() == 0)
            return false;

//        for(int i=0; i < str.length(); i++){
//            if (target == str.charAt(i)){
//                return true;
//            }
//        }
//        return false;

        for (char letter : str.toCharArray()) {
            if (letter == target) {
                return true;
            }
        }
        return false;
    }

    // Search for a target in a range of a specific index
    public static int searchInRangeMinMax(int[] nums, int start, int end, int target) {

        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Find the minimum number in the array
    public static int minInList(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                return nums[i];
            }
        }
        return min;
    }

    // Find the index of an element in a 2D array
    public static int[] linearSearch2D(int[][] nums, int target) {

        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[row].length; col++) {
                if (nums[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int maxIn2D(int[][] nums) {
        int max = nums[0][0];
        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[row].length; col++) {
                if (nums[row][col] > max) {
                    max = nums[row][col];
                }
            }
        }
        return max;
    }

    // https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    public static int findNumbers(int[] nums) {
        int i = 0, count = 0;
        while (i < nums.length) {
            if (isEven(nums[i])) {
                count++;
            }
            i++;
        }
        return count;
    }

    static boolean isEven(int n) {
        if (numOfDigits(n) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static int numOfDigits(int n) {
        if (n < 0) {
            n *= -1;
        }
        if (n == 0) {
            return 1;
        }
        int i = 0;

        while (n > 0) {
            i++;
            n /= 10;  // extract the last number from a set of digits
        }
        return i;
    }

    // https://leetcode.com/problems/richest-customer-wealth/
    public int maximumWealth(int[][] accounts) {

        int ans = accounts[0][0];
        for (int person = 0; person < accounts.length; person++) {
            int sumOfWealth = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sumOfWealth += accounts[person][account];
            }

            if (sumOfWealth > ans) {
                ans = sumOfWealth;
            }

        }
        return ans;
    }

    // https://leetcode.com/problems/minimum-common-value/description/
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0, right = 0;

        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else {
                return nums1[left];
            }
        }
        return -1;
    }


    // https://leetcode.com/problems/valid-perfect-square/
    public static boolean isPerfectSquare(int num) {
        int start = 1, end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid * mid) == num) {
                return true;
            } else if ((mid * mid) > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    // https://leetcode.com/problems/kth-missing-positive-number/description/
    // O(log n)
    public static int kthMissingPositiveNumber(int arr[], int k) {
        int start = 0, end = arr.length;

        while (end > start) {
            int middle = start + (end - start) / 2;
            int missing = arr[middle] - 1 - middle;

            if (k <= missing) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return end + k;
    }

    // https://leetcode.com/problems/search-insert-position/
    // Same as ceiling of  a number, we return start when not found
    public static int searchInsertPosition(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        if (target > arr[end]) {
            return -1;
        }
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return start;
    }

    /*
    Find floor of a number in an order number arrays
    Same as binary or ceiling, but just return end when the target isn't found.
    Floor is the greatest number that is smaller or equal to the target number.
     */
    public static int floorOfNumber(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return end;
    }

    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length; // Length of the character array
        int start = 0, end = n - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (letters[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return letters[start % n]; // Get the index of start and length modulus
    }

    // https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
    public static int specialArray(int[] nums) {
        int end = nums.length;
        int start = 0;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= middle)
                    count++;
            }
            if (count == middle)
                return middle;
            else if (count < middle)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }

    // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
    public static int countNegativeNumbers(int[][] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = 0, end = nums[i].length - 1;

            while (start <= end) {
                int middle = start + (end - start) / 2;

                if (nums[i][middle] < 0) {
                    count += start - middle + 1;
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return count;
    }

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int[] searchInRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        ans[0] = firstAndLastPosition1(nums, target, true);
        ans[1] = firstAndLastPosition1(nums, target, false);
        return ans;
    }

    private static int firstAndLastPosition1(int[] nums, int target, boolean firstOccurence) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                if (firstOccurence)
                    end = mid - 1; // go to left to check if there is still remaining
                else
                    start = mid + 1; // go to right
            }
        }
        return ans;
    }

    // https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    // Find position of an element in a sorted array of infinite numbers
    // Double the size of the array until the target position if found
    // [3, 4, 5, 6, 7, 8] target = 6
    public static int elementOfInfiniteArray(int[] nums, int target){
        // first find the range
        // then start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > nums[end]){
            int temp = end + 1; // Our new start position number 2

            end = end + (end - start + 1) * 2;
            // double the size
            start = temp;
        }
        return binarySearch(nums, target, start, end);
    }

    private static int binarySearch(int[] nums, int target, int start, int end){

        while (start <= end){
            int middle = start + (end - start) / 2;

            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }

    // https://leetcode.com/problems/intersection-of-two-arrays/submissions/
    public static int[] intersectionOfArrays(int[]nums1, int[]nums2){
        Set<Integer> common=new HashSet<>();

        Arrays.sort(nums2);
        for (Integer num: nums1){
            if (isFound(nums2, num))
                common.add(num);
        }
        int j = 0;
        int[] ans=new int[common.size()];
        for (Integer i: common){
            ans[j++] = i;
        }
        return ans;
    }

    // This check if the target element is found in the array
    private static boolean isFound(int[]nums, int target){
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid=start + (end - start) / 2;

            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
