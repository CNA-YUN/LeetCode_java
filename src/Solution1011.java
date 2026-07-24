public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        long low = weights[0], high;
        long sum = 0;
        for (int w : weights) {
            low = Math.max(w, low);
            sum += w;
        }
        high = sum;
        while (low <= high) {
            long mid = (low + high) / 2;
            int count = check(weights, mid);
            if (count > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low > sum ? (int) sum : (int) low;
    }

    private int check(int[] weights, long cap) {
        int days = 0;
        int sum = 0;
        int id = 0;
        int len = weights.length;
        while (id < len) {
            sum += weights[id];
            if (sum > cap) {
                sum = 0;
                days++;
            } else if (sum == cap) {
                days++;
                id++;
                sum = 0;
            } else {
                id++;
            }
        }
        if (sum != 0) {
            days++;
        }
        return days;
    }
}
