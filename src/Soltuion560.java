import java.util.HashMap;
import java.util.Map;

public class Soltuion560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int cnt = 0;
        for (int num : nums) {
            prefix += num;
            cnt += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return cnt;
    }
}
