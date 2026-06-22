class Solution {
    public double myPow(double x, int n) {

        // handle negative exponent
        long N = n; // use long to avoid overflow when doing -n on Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {

        // base case
        if (n == 0) return 1.0;

        // recursive case: compute half
        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;         // even power → just square half
        } else {
            return half * half * x;     // odd power → square half × one more x
        }
    }
}