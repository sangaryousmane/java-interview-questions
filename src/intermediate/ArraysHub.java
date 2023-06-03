package intermediate;

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
            for (int i = 0; i < n; i++){
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
    public static int[] getConcatenation(int[] nums){
        int[] ans=new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
            ans[i+ nums.length] = nums[i];
        }
        return ans;
    }

    // https://leetcode.com/problems/richest-customer-wealth/
    // Enhanced for loop
    public static int maximumWealth(int[][] accounts){
        int maximumWealth=accounts[0][0];
        for (int []person: accounts) {
            int sumOfWealth = 0;
            for (int account: person) {
                sumOfWealth += account; // sum amount in each account
            }

            if (sumOfWealth > maximumWealth){
                maximumWealth=sumOfWealth;
            }
        }
        return maximumWealth;
    }
}
