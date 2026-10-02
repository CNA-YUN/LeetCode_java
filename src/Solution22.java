import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String s, int i, int i1, int n) {
        if (i == n && i1 == n) {
            res.add(s);
            return;
        }
        if (i < n) {
            dfs(res, s + "(", i + 1, i1, n);
        }
        if (i1 < i) {
            dfs(res, s + ")", i, i1 + 1, n);
        }
    }
}
