package intermediate;

public class FindInMountain {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     * public int get(int index) {}
     * public int length() {}
     * }
     */
    public static int findInMountainArray(int target, int[] nums) {
        int peak = peakMountain(nums);
        int firstTry = orderAgnosticBinarySearch(nums, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBinarySearch(nums, target, peak + 1, nums.length - 1);
    }

    public static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end) {

        // It is ascending if the start is less than the end
        boolean isAsc =nums[start] < nums[end];

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

    public static int peakMountain(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] > nums[middle + 1]) {
                end = middle; // Decreasing order
            } else {
                start = middle + 1; // Increasing order
            }
        }
        return start;
    }

}

