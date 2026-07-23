import java.util.Arrays;


public class SolutionLCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = increase.length;
        int m = requirements.length;
        int[] visited = new int[m];
        int[][] sum = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + increase[j - 1][i];
            }
        }
        for (int cnt = 0; cnt < m; cnt++) {
            int mx = 0;
            for (int i = 0; i < 3; i++) {
                int[] tmp = sum[i];
                int target = requirements[cnt][i];
                mx = Math.max(mx, lowerBound(tmp, target));
            }
            visited[cnt] = mx > n ? -1 : mx;
        }
        return visited;
    }

    private int lowerBound(int[] arr, int target) {
        /*
        arr 非递减
        return: >= target 的最小元素下标
         */
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
