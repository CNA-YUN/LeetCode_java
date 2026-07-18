import java.util.Arrays;

public class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int m = words.length;
        int[] query = new int[n];
        int[] word = new int[m];
        int[] result = new int[n];

        for (int i = 0; i < queries.length; i++) {
            query[i] = countminLetter(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            word[i] = countminLetter(words[i]);
        }
        Arrays.sort(word);
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            int target = query[i];
            /*
            求 大于 target 的第一个元素的下标
             */
            while (left <= right) {
                int mid = (left + right) / 2;
                if (word[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            result[i] = left == m ? 0 : m - left;
        }
        return result;
    }

    public int countminLetter(String s) {
        int n = s.length();
        int count = 0;
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                return counts[i];
            }
        }
        return 0;
    }
}
