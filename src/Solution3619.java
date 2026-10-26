public class Solution3619 {
    public int countIslands(int[][] grid, int k) {
        int r = grid.length, c = grid[0].length;
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] != 0 && dfs(grid, i, j) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private long dfs(int[][] grid, int x, int y) {
        int r = grid.length, c = grid[0].length;
        if (x < 0 || r <= x || y < 0 || c <= y || grid[x][y] == 0) {
            return 0;
        }
        long mid = grid[x][y];
        grid[x][y] = 0;
        long l = dfs(grid, x, y - 1);
        long right = dfs(grid, x, y + 1);
        long u = dfs(grid, x - 1, y);
        long d = dfs(grid, x + 1, y);
        return mid + l + right + u + d;
    }

}
