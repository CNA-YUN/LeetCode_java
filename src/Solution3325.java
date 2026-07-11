import java.util.HashMap;

public class Solution3325 {
    public int numberOfSubstrings(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while(map.get(s.charAt(i)) >= k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            cnt+=left;
        }
        return cnt;
    }
}
