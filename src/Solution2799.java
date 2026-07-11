import java.util.HashMap;
import java.util.HashSet;

public class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            while (map.size() == set.size()) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += left;
        }
        return count;
    }
}
