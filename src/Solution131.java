import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> res = new ArrayList<>();
    public List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        dfs(0, s);
        return res;
    }

    public void dfs(int i, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (check(s, i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }

    // 检查 path 中的字符串是否为回文串
    public boolean check(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
