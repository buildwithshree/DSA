import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> left  = new ArrayList<>();
        List<Integer> mid   = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // split into 3 groups
        for (int num : nums) {
            if (num < pivot)      left.add(num);
            else if (num == pivot) mid.add(num);
            else                  right.add(num);
        }

        // join all 3 into result array
        int[] result = new int[nums.length];
        int i = 0;

        for (int num : left)  result[i++] = num;
        for (int num : mid)   result[i++] = num;
        for (int num : right) result[i++] = num;

        return result;
    }
}
