public class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long high = time[0];
        int n = time.length;
        for (int t : time) {
            high = Math.min(high, t);
        }
        high = totalTrips * high;
        long low = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(time, mid) < totalTrips) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private long check(int[] nums, long t) {
        long count = 0;
        for (int num : nums) {
            count += t / num;
        }
        return count;
    }
}
