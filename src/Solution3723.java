public class Solution3723 {
    public String maxSumOfSquares(int num, int sum) {
        if (9 * num < sum)
            return "";
        int maxdigit = sum / 9;
        int carry = sum % 9;
        StringBuilder sb = new StringBuilder();
        sb.append("9".repeat(Math.max(0, maxdigit)));
        if (carry > 0)
            sb.append(carry);
        while (sb.length() < num) {
            sb.append('0');
        }
        return sb.toString();
    }
}
