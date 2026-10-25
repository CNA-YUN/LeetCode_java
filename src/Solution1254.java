public class Solution1254 {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }
        for (int i = 0; i < row; i++) {
            int step = col - 1;
            if (i == 0 || i == row - 1) {
                step = 1;
            }
            for (int j = 0; j < col; j += step) {
                dfs(grid, i, j);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int x, int y) {
        int r = grid.length, c = grid[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 1;
        dfs(grid, x - 1, y);// up
        dfs(grid, x + 1, y);// down
        dfs(grid, x, y - 1);// left
        dfs(grid, x, y + 1);// right
    }
}
