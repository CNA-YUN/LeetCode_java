public class Solution3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char[] res = new char[n];
        int k = 0;
        for (String s : words) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += weights[s.charAt(i) - 'a'];
            }
            sum %= 26;
            res[k++] = (char) ('z' - sum);
        }
        return new String(res);
    }
}
