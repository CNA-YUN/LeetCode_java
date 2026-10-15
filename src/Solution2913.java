import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2913 {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> cnt = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cnt.clear();
            for (int j = i; j < n; j++) {
                cnt.put(nums.get(j), cnt.getOrDefault(nums.get(j), 0) + 1);
                sum += cnt.size() * cnt.size();
            }
        }
        return sum;
    }
}
