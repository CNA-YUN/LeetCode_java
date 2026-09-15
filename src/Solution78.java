import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<Integer> path;
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        result = new ArrayList<>();
        path = new ArrayList<>();
        dfs(0, n, nums);
        return result;
    }

    public void dfs(int i, int n, int[] nums) {
        if (i == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        dfs(i + 1, n, nums);
        path.add(nums[i]);
        dfs(i + 1, n, nums);
        path.remove(path.size() - 1);
    }
}
