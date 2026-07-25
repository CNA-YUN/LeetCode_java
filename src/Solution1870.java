public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = (int) 1e7;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean j = check(dist, mid, hour);
            if (j) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low > 1e7 ? -1 : low;
    }

    private boolean check(int[] dist, int v, double hour) {
        double t = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) {
                t += (double) dist[i] / v;
            } else {
                t += (dist[i] + v - 1) / v;
            }
            if (t > hour) {
                return false;
            }
        }
        return true;
    }
}
