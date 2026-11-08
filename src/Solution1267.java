public class Solution1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // 第一遍：统计每行、每列的服务器数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        // 第二遍：判断每台服务器能否通信
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
