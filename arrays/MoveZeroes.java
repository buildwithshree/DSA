class Solution {
    public void moveZeroes(int[] nums) {

        int insert = 0; // position to place next non-zero

        // place all non-zeros first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insert] = nums[i];
                insert++;
            }
        }

        // fill remaining positions with 0
        while (insert < nums.length) {
            nums[insert] = 0;
            insert++;
        }
    }
}
