import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // empty subarray has sum 0

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            int need = currentSum - k;  // have I seen this before?

            if (map.containsKey(need)) {
                count += map.get(need);  // add how many times seen
            }

            // store current sum in map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}