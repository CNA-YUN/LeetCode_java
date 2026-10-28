public class Solution3882 {
    private int ans = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int orAll = 0;
        for (int[] row : grid) {
            for (int x : row) {
                orAll |= x;
            }
        }
        boolean[][][] vis = new boolean[r][c][orAll + 1];
        dfs(grid, r - 1, c - 1, 0, vis);
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int xor, boolean[][][] vis) {
        if (ans == 0 || x < 0 || y < 0 || vis[x][y][xor]) {
            return;
        }
        vis[x][y][xor] = true;
        xor ^= grid[x][y];
        if (x == 0 && y == 0) {
            ans = Math.min(ans, xor);
            return;
        }
        dfs(grid, x - 1, y, xor, vis);
        dfs(grid, x, y - 1, xor, vis);
    }
}
