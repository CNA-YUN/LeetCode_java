import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    char[] path;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        path = new char[digits.length()];
        dfs(0, digits);
        return result;
    }

    public void dfs(int index, String digits) {
        if (index == digits.length()) {
            result.add(new String(path));
        } else {
            for (char c : map[digits.charAt(index) - '0'].toCharArray()) {
                path[index] = c;
                dfs(index + 1, digits);
            }
        }

    }
}
