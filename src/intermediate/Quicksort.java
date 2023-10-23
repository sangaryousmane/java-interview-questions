package intermediate;

import java.util.Random;

import static intermediate.Sorting.swap;

public class Quicksort {

    // Approach 1, without lomuto partition
    public static void quickSort(int[] nums, int smallest, int highest) {
        if (smallest >= highest)
            return;

        int start = smallest;
        int end = highest;
        int middle = start + (end - start) / 2;
        int pivot = nums[middle]; // the pivot element is the middle element

        while (start <= end) {
            while (nums[start] < pivot)
                start++;

            while (nums[end] > pivot)
                end--;

            if (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        // my pivot is at correct index, sort the two halves now
        quickSort(nums, smallest, end);
        quickSort(nums, start, highest);
    }


    public static void quicksortPretty(int[] nums){
        quicksortLomuto(nums, 0, nums.length - 1);
    }

    // Approach 2, Quicksort using lomuto partition
    public static void quicksortLomuto(int[] nums, int start, int end) {
        // First, check the case only one element left to sort
        if (start >= end || nums == null)
            return;

        int pivotIndex = partition(nums, start, end);

        // Quick sort the elements on the left of pivot(excluding the pivot)
        quicksortLomuto(nums, start, pivotIndex - 1);

        // Quick sort the elements on the right of the pivot(excluding the pivot)
        quicksortLomuto(nums, pivotIndex + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int leftPointer = start;
        int rightPointer = end;

        while (leftPointer < rightPointer) {

            // Walk from the left to pivot
            while (nums[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            // Walk from the right to pivot
            while (nums[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // If the left and right pointers meet, kindly swap them
            swap(nums, leftPointer, rightPointer);
        }
        // Swap the left pointer with the last element of the array
        swap(nums, leftPointer, end);
        return leftPointer;
    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " , ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        System.out.println("BEFORE");
        printArray(nums);

        quicksortPretty(nums);

        System.out.println("AFTER");
        printArray(nums);

    }

}
