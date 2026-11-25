
import java.util.*;

public class Solution3934 {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        return binarySearch(1, n, nums);
    }

    private int binarySearch(int left, int right, int[] nums) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int len, int[] nums) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> mapper = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            sb.append(nums[right]).append(",");
            if (right - left + 1 > len) {
                int index = sb.indexOf(",");
                sb.delete(0, index + 1);
                left++;
            }
            if (right - left + 1 == len) {
                mapper.put(sb.toString(), mapper.getOrDefault(sb.toString(), 0) + 1);
            }

        }
        for (Integer value : mapper.values()) {
            if (value == 1) {
                return true;
            }
        }
        return false;
    }
}
