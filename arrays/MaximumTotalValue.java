class Solution {
    public long maximumTotalValue(int[] nums, int k) {

        int globalMax = nums[0];
        int globalMin = nums[0];

        // find global max and min
        for (int num : nums) {
            if (num > globalMax) globalMax = num;
            if (num < globalMin) globalMin = num;
        }

        // best single subarray value * k
        return (long)(globalMax - globalMin) * k;
    }
}
