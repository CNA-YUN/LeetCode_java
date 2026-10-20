import java.util.ArrayList;
import java.util.List;

class Solution3886 {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int boundary = (int) Math.sqrt(n);
        for (int i = 1; i <= boundary; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i);
            }
        }
        int res = 0;
        for (Integer k : list) {
            if (check(nums, k)) {
                res += k;
            }
        }
        return res;
    }

    private boolean check(int[] nums, int k) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += k) {
            int unormal = 0;
            int tmn = Integer.MAX_VALUE;
            int tmx = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                int cur = nums[i + j];
                int next = nums[i + (j + 1) % k];
                if (cur > next) {
                    unormal++;
                }
                if (unormal > 1) {
                    return false;
                }
                tmn = Math.min(cur, tmn);
                tmx = Math.max(cur, tmx);
            }
            if (tmn < mx) {
                return false;
            }
            mx = tmx;
        }
        return true;
    }
}