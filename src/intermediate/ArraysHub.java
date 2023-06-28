package intermediate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysHub {

    // Build Array from Permutation
    // https://leetcode.com/problems/build-array-from-permutation/
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    // https://leetcode.com/problems/running-sum-of-1d-array/description/
    public static int[] runningSum(int[] nums) {
        int n = nums.length;

        if (n > 0) {
            int[] runSum = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                runSum[i] = sum;
            }
            return runSum;
        }
        return nums;
    }

    // https://leetcode.com/problems/build-array-from-permutation/description/
    public static int[] permutationBuildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            //
            ans[i] = nums[nums[i]];
            i++;
        }
        return ans;
    }

    // https://leetcode.com/problems/concatenation-of-array/
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    // https://leetcode.com/problems/richest-customer-wealth/
    // Enhanced for loop
    public static int maximumWealth(int[][] accounts) {
        int maximumWealth = accounts[0][0];
        for (int[] person : accounts) {
            int sumOfWealth = 0;
            for (int account : person) {
                sumOfWealth += account; // sum amount in each account
            }

            if (sumOfWealth > maximumWealth) {
                maximumWealth = sumOfWealth;
            }
        }
        return maximumWealth;
    }

    /*
    https://leetcode.com/problems/shuffle-the-array/
    Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[2 * n];

        for (int i = 0; i < n; ++i) {
            shuffled[2 * i] = nums[i];
            shuffled[2 * i + 1] = nums[n + i];
        }
        return shuffled;
    }

    // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int i = 0, maxCandy = 0;

        while (i < candies.length) {
            if (candies[i] > maxCandy) {
                maxCandy = candies[i];
            }
            i++;
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandy);
        }
        return result;
    }

    // https://leetcode.com/problems/number-of-good-pairs/description/
    public static int numIdenticalPairs(int[] nums) {
        int i, j, goodPairs = 0;


        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    goodPairs += 1;
                }
            }
        }
        return goodPairs;
    }

    // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
    public static int[] smallerNumberThanCurrent(int[] nums) {
        int i, j;
        int[] smaller = new int[nums.length];


        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    smaller[i] = smaller[i] + 1;
                } else if (nums[j] != nums[i])
                    smaller[j] = smaller[j] + 1;
            }
        }
        return smaller;
    }

    // https://leetcode.com/problems/create-target-array-in-the-given-order/description/
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        int i = 0;
        while (i < target.size()) {
            result[i] = target.get(i);
            i++;
        }
        return result;
    }

    // https://leetcode.com/problems/check-if-the-sentence-is-pangram/
    public static boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (char letter : sentence.toCharArray()) {
            letters.add(letter);
        }
        return letters.size() == 26;
    }

    public static int[] searchInMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return new int[]{row, column};
            }

            if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }
}
