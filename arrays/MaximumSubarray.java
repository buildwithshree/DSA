class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];     // best sum seen so far
        int currentSum = 0;       // running sum

        for (int num : nums) {
            currentSum += num;                        // extend subarray

            if (currentSum > maxSum) {
                maxSum = currentSum;                  // update best
            }

            if (currentSum < 0) {
                currentSum = 0;                       // reset, negative is useless
            }
        }

        return maxSum;
    }
}