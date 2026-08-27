public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int mx = 0;
        for (int j : gain) {
            sum += j;
            if (sum > mx) {
                mx = sum;
            }
        }
        return mx;
    }
}
