import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    List<Integer> ans = new ArrayList<>();
    int bound;

    public List<Integer> lexicalOrder(int n) {
        bound = n;
        for (int i = 1; i < 10; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int cur) {
        if (cur > bound) {
            return;
        }
        ans.add(cur);
        int tmp = cur * 10;
        for (int i = 0; i < 10; i++) {
            dfs(tmp + i);
        }
    }
}
