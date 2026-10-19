public class Solution829 {
    public int consecutiveNumbersSum(int n) {
        int right = (int) Math.sqrt(2 * n);
        int res = 0;
        for (int k = 1; k <= right; k++) {
            if (2 * n % k == 0 && (2 * n / k - k + 1) % 2 == 0 && (2 * n / k - k + 1) / 2 >= 1) {
                res++;
            }
        }
        return res;
    }
}
