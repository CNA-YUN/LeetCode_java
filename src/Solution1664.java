public class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int n = nums.length;
        int s1 = 0, s2 = 0;// s1:odd;s2:even
        int t1 = 0, t2 = 0;// t1:odd;t2:even
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s2 += nums[i];
            } else {
                s1 += nums[i];
            }

        }
        for (int i = 0; i < n; i++) {
            int odd, even;
            if (i % 2 == 0) {
                odd = t1 + s2 - t2 - nums[i];
                even = t2 + s1 - t1;
                t2 += nums[i];
            } else {
                odd = t1 + s2 - t2;
                even = t2 + s1 - t1 - nums[i];
                t1 += nums[i];
            }
            if (odd == even) {
                res++;
            }
        }
        return res;
    }
}
