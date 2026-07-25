public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = (int) 1e9;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean res = check(piles, mid, h);
            if (res) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums, int k, int threshold) {
        long cnt = 0;
        for (int num : nums) {
            cnt += (num + k - 1) / k;
            if (cnt > threshold) {
                return false;
            }
        }
        return cnt <= threshold;
    }
}
