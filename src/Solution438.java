import java.util.ArrayList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int left = 0, right = s.length() - 1;
        for (int i = 0; i <= right; i++) {
            window[s.charAt(i) - 'a']++;
            if (i - left + 1 < p.length()) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (window[j] != need[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(left);
            }
            window[s.charAt(left) - 'a']--;
            left++;
        }
        return ans;
    }
}
