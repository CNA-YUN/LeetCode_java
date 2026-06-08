import java.util.Arrays;

class Solution2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int remain = n % 3;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            while (i <= remain) {
                result += cost[i - 1];
                i++;
            }
            if ((i-remain) % 3 != 1 && i <= n) {
                result += cost[i - 1];
            }

        }
        return result;
    }
}