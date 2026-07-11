import java.util.HashMap;
import java.util.Map;

public class Solution2062 {
    public int countVowelSubstrings(String word) {
        char[] s = word.toCharArray();
        HashMap<Character, Integer> cnt = new HashMap<>();
        int ans = 0;
        int start = 0;
        int left = 0;

        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if ("aeiou".indexOf(ch) < 0) {
                cnt.clear(); // 重置
                start = left = i + 1;
                continue;
            }

            // 做法类似 1358. 包含所有三种字符的子字符串数目（哈希表写法）
            cnt.merge(ch, 1, Integer::sum); // cnt[ch]++
            while (cnt.size() == 5) { // 窗口包含所有元音
                char out = s[left];
                int c = cnt.merge(out, -1, Integer::sum); // c = --cnt[out]
                if (c == 0) {
                    cnt.remove(out);
                }
                left++;
            }
            ans += left - start;
        }

        return ans;



    }
}
