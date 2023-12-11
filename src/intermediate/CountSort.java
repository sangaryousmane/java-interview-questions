package intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Is a non-swapping algorithms, and it is good for small amount of numbers
// Frequency array is how frequent an element appears in an array
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 9, 40, 2, 4, 9, 7, 11};
        System.out.println("Before: " + Arrays.toString(arr));
        countSortHashMap(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    public static void countSortHashMap(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        Map<Integer, Integer> hash = new HashMap<>();

        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = hash.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                nums[index] = i;
                index++;
            }
        }
    }

    // O(N) + 1 for both time and space complexity
    public static void countSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int max = nums[0];
        for (int num : nums)
            if (num > max)
                max = num;

        int[] countArray = new int[max + 1];
        // create frequency array
        for (int n : nums)
            countArray[n]++;

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                nums[index] = i;
                index++;
                countArray[i]--;
            }
        }

    }
}
