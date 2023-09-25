package intermediate;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println("Before: " + Arrays.toString(nums));
        nums = mergeSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }


    static int[] mergeSort(int[] nums) {

        if (nums.length == 1)
            return nums;

        int middle = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(nums, middle, nums.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // At the end, it may be possible that one of the arrays it not complete
        // copy the remaining elements. Please note that either of the loops will run
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
