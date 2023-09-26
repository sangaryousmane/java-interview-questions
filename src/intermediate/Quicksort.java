package intermediate;

import java.util.Random;

import static intermediate.Sorting.swap;

public class Quicksort {

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


    // Quicksort using lomuto partition
    public static void quicksortLomuto(int[] nums, int start, int end) {
        if (start >= end || nums == null)
            return;
        int pivotIndex = partition(nums, start, end);

        // Quick sort the partitions
        quicksortLomuto(nums, start, pivotIndex - 1); // from start to the pivot
        quicksortLomuto(nums, pivotIndex + 1, end); // from the pivot to the end
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int leftPointer = start;
        int rightPointer = end;

        // Loop as long the element on the left is less than one of the right
        while (leftPointer < rightPointer) {
            while (nums[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (nums[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(nums, leftPointer, rightPointer);
        }
        swap(nums, leftPointer, end); // swap left with the end
        return leftPointer;
    }

    public static void printArray(int[] nums){
        for (int i: nums){
            System.out.print(i + " , ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Random random=new Random();
        int []nums= new int[10];

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(100);
        }

        System.out.println("BEFORE");
        printArray(nums);

        quickSort(nums, 0, nums.length - 1);

        System.out.println("AFTER");
        printArray(nums);

    }

}
