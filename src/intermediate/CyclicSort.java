package intermediate;

import java.util.ArrayList;
import java.util.List;

public class CyclicSort {


    public static void cyclic(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }

    // https://leetcode.com/problems/missing-number/description/
    public static int missingElement(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else i++;
        }

        // Run a loop to find the missing element
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index)
                return index;
        }
        return nums.length;
    }

    public static List<Integer> disappearedNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Return all elements that are not in the sorted list
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1)
                result.add(index + 1);
        }
        return result;
    }


    public static int findDuplicate(int[] nums) {
        int i = 0;


        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;

                if (nums[i] != nums[correctIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                } else return nums[i];
            } else i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(findDuplicate(nums));
    }
}
