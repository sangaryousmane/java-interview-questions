package intermediate;

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

        while (nums[start] + nums[end] != target){
            if (nums[start] + nums[end] > target){
                end--;
            }
            else {
                start++;
            }
        }
        return new int[] {start+1, end+1};
    }

    // https://leetcode.com/problems/arranging-coins/
    public static int arrangeCoins(int n) {
        int i = 1;

        while (n > 0) {
            i++;
            n -= i;
        }
        return i - 1;
    }

    // https://leetcode.com/problems/find-smallest-letter-greater-than-target
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        char ans = letters[0];

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if ((letters[middle] == target) || (target > letters[middle])) {
                start = middle + 1;
            } else if (letters[middle] > target) {
                ans = letters[middle];
                end = middle - 1;
            }
        }
        return ans;
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

        boolean isAsc = nums[start] < nums[end];

        while (start <= end) {
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
    public static int searchInRange(int[] nums, int start, int end, int target) {

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

        while(start <= end){
            int mid = start + (end - start) / 2;

            if ((mid * mid) == num){
                return true;
            }
            else if ((mid * mid) > num){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }
}
