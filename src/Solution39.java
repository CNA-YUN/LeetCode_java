import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target)
                break;
            path.add(nums[i]);
            dfs(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        }
    }
}
