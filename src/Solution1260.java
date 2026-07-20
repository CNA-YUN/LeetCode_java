import java.util.ArrayList;
import java.util.List;

public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] temp = new int[m][n];
        temp = grid;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            temp = getGrid(temp);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans.get(i).add(temp[i][j]);
            }
        }
        return ans;
    }

    private int[][] getGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[m];
        for (int row = 0; row < m; row++) {
            if (row == 0) {
                temp[row] = grid[m - 1][n - 1];
            } else {
                temp[row] = grid[row - 1][n - 1];
            }

        }
        for (int col = n - 1; col > 0; col--) {
            for (int row = 0; row < m; row++) {
                grid[row][col] = grid[row][col - 1];
            }
        }
        for (int row = 0; row < m; row++) {
            grid[row][0] = temp[row];
        }
        return grid;
    }
}
