import java.util.HashMap;
import java.util.Map;

public class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = (s[i] + nums[i]) % p;
        }
        int x = s[n];
        if (x == 0) {
            return 0; // 移除空子数组（这行可以不要）
        }
        int ans = n;
        Map<Integer, Integer> last = new HashMap<>(n + 1, 1); // 预分配空间
        for (int i = 0; i <= n; i++) {
            last.put(s[i], i);
            // 如果不存在，-n 可以保证 i-j >= n
            int j = last.getOrDefault((s[i] - x + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }
}
