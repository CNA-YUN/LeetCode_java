import java.util.ArrayList;
import java.util.List;

class Solution22 {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        dfs(left, right);
        return ans;
    }

    private void dfs(int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            dfs(left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            dfs(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}