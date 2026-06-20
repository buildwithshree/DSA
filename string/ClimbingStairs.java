package string;

class Solution {
    
    int[] memo = new int[46]; // stores already-computed answers, -1 = not computed yet

    public int climbStairs(int n) {

        // base cases
        if (n == 0) return 1;
        if (n == 1) return 1;

        // if already computed, return saved answer instantly
        if (memo[n] != 0) return memo[n];

        // recursive case — compute and SAVE before returning
        memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return memo[n];
    }
}
