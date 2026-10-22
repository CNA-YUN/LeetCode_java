public class Solution3942 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int increase = 0, in = n;
        int decrease = 0, de = n;
        for (int i = 0; i < n; i++) {
            int cur = nums[i], next = nums[(i + 1) % n];
            if (cur > next) {
                decrease += 1;
                de = i;
            } else if (cur < next) {
                increase += 1;
                in = i;
            }
            if (increase > 1 && decrease > 1) {
                return -1;
            }
        }
        if (decrease == 1) {
            if (de == n - 1) {
                return 0;
            }
            return Math.min(de + 1, n - de + 1);
        }

        if (increase == 1) {
            if (in == n - 1)
                return 1;
            return Math.min(in + 2, n - in);
        }
        return 0;
    }
}
