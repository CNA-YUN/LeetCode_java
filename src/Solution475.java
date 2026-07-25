import java.util.Arrays;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 1, high = (int) 1e9;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(houses, heaters, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] houses, int[] heaters, int radius) {
        int lenhouses = houses.length;
        int lenheaters = heaters.length;
        int i = 0, j = 0;
        while (i < lenhouses && j < lenheaters) {
            if (heaters[j] - radius <= houses[i] && heaters[j] + radius >= houses[i]) {
                i++;
            } else {
                j++;
            }
        }
        return i >= lenhouses;
    }
}
