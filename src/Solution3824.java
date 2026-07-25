public class Solution3824 {
    public int minimumK(int[] nums) {

        int low = 1, high = (int) 1e5;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean judge = check(nums, mid);
            if (judge) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums, int k) {
        long cnt = 0;
        for (int num : nums) {
            cnt += (num + k - 1) / k;
            if (cnt > (long) k * k) {
                return false;
            }
        }
        return true;
    }
}
