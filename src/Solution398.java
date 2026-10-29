import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution398 {
    private Map<Integer, List<Integer>> cnt;
    private Random randompick;

    public Solution398(int[] nums) {
        cnt = new HashMap<>();
        randompick = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (cnt.get(nums[i]) == null) {
                cnt.put(nums[i], new ArrayList<>());
            }
            List<Integer> list = cnt.get(nums[i]);
            list.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = cnt.get(target);
        return list.get(randompick.nextInt(list.size()));
    }
}
