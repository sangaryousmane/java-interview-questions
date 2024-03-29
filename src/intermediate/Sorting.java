package intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sorting {


    // https://leetcode.com/problems/set-mismatch/submissions/
    // TODO: set mismatch - a leetcode problem with cyclic sort intuition
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        cyclicSort(nums, i);
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return new int[]{nums[i], i + 1};
        }
        return new int[]{-1, -1};
    }

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        cyclicSort(nums, i);

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1)
                ans.add(nums[index]);
        }
        return ans;
    }

    // https://leetcode.com/problems/single-number/
    // TODO: finding a single number in an array
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    // https://leetcode.com/problems/find-the-duplicate-number/description/
    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {

            if (nums[i] != i + 1) {
                int correct = nums[i] - 1; // 1 to n

                if (nums[i] != nums[correct]) {
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;

    }

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> ans = new ArrayList<>();

        // Apply cyclic sort on the array
        cyclicSort(nums, i);

        // Check for the numbers that are not in the range of numbers
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(index + 1);
            }
        }
        return ans;
    }

    private static void cyclicSort(int[] nums, int i) {
        int correctIndex;
        while (i < nums.length) {

            if (nums[0] == 0)
                correctIndex = nums[i]; // from 0 to n
            else
                correctIndex = nums[i] - 1; // from 1 to n

            // if the number is not at the correct index, swap
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else
                i++;
        }
    }

    // Only number in the range that is missing from the array
    // https://leetcode.com/problems/missing-number/description/
    public static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i]; // index of current element

            // Swap the elements of the array
            if (arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Check for the missing number in the array
        // A number is missing when it's not equal to it current index
        // case 1
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;  // if the element is not equal to it current index, then the index is the missing
            }
        }

        // return the length of the element if the missing element is the
        // ith element that is not in the array. eg: [0, 1, 2, 3]. missing element is 4
        return arr.length;
    }

    // Perform cyclic sort
    public static void cyclicSort(int[] arr) {
        // Iterate over the array once
        // check if the current element is equal
        // to the value of the element's index minus one
        // swap if not, else go to the next element
        int i = 0;
        cyclicSort(arr, i);
    }

    // Perform insertion sort. It is stable
    public static void insertionSort(int[] arr) {
        // Take a number and compare it with previous nums
        // Insert it to the rightful position
        // Repeat this until the entire array is sorted for n - 1 where j > 0

        if (arr == null || arr.length < 2)
            return;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                else
                    break;
            }
        }
    }

    // Perform selection sort
    public static void selectionSort(int[] arr) {

        // Find index of last element
        // Find maximum number
        // swap maximum number with last index
        // keep taking the minimum number in the array and swap it with the
        // number at the last index
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length - i - 1; // select the last element
            int maxIndex = getMaxIndex(arr, 0, lastIndex); // select the maximum element
            swap(arr, maxIndex, lastIndex); // Swap the elements when condition is true
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int lastIndex) {
        int max = start;

        for (int i = start; i <= lastIndex; i++) {
            if (arr[max] < arr[i])
                max = i;
        }
        return max;
    }

    public static void bubbleSort(int[] arr) {
        boolean isSwapped;
        // Get an outer for loop as a counter
        // Get an inner for loop for swapping elements of the array
        // if the current element is greater than the previous element, swap
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;

            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;
                    System.out.println(Arrays.toString(arr));
                }
            }
            if (!isSwapped) // if there was no swapping
                break;
        }
    }
}
