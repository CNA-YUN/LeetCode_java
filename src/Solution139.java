import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    Set<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String tmp : wordDict) {
            dict.add(tmp);
        }
        if (check(s)) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && check(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean check(String str) {
        if (dict.contains(str)) {
            return true;
        } else {
            return false;
        }
    }
}
