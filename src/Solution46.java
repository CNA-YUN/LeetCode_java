import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    List<Integer> path = new ArrayList<>();
    int n;
    List<Integer> arr;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        arr = new ArrayList<>();
        for (int x : nums) {
            arr.add(x);
        }
        visited = new boolean[n];
        dfs();
        return ans;

    }

    private void dfs() {
        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                path.add(arr.get(i));
                visited[i] = true;
                dfs();
                path.removeLast();
                visited[i] = false;
            }
        }
    }

}
