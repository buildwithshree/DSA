import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map stores: number → its index

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i]; // what number do I need?

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i}; // found the pair!
            }

            map.put(nums[i], i); // store current number and index
        }

        return new int[]{}; // never reached (problem guarantees a solution)
    }
}