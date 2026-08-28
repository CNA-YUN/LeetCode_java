import java.util.*;

public class Solution1887 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int sum = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            sum += map.get(list.get(i));
            res += sum;
        }
        return res;
    }
}
