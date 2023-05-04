package intermediate;

public class Arrays {

    // Build Array from Permutation
    // https://leetcode.com/problems/build-array-from-permutation/
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    // https://leetcode.com/problems/running-sum-of-1d-array/solutions/2699842/python-c-java-faster-than-100-simple-short-solution-2-line-solution/
    public int[] runningSum(int[] nums){

        for(int i =0; i < nums.length; i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
