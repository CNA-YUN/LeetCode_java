import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (last.containsKey(nums[i]) && Math.abs(i - last.get(nums[i])) <= k) {
                return true;
            } else {
                last.put(nums[i], i);
            }
        }
        return false;
    }
}
