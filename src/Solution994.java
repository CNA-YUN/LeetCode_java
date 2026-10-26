import java.util.ArrayDeque;
import java.util.Queue;

public class Solution994 {
    Queue<int[]> q;
    int fresh;
    int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int orangesRotting(int[][] grid) {
        q = new ArrayDeque<>();
        fresh = 0;
        int r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int t = 0;
        while (!q.isEmpty() && fresh > 0) {
            t++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] bad = q.poll();
                becomeBad(grid, bad);
            }
        }
        return fresh > 0 ? -1 : t;
    }

    private void becomeBad(int[][] grid, int[] pos) {
        int m = grid.length, n = grid[0].length;
        for (int[] d : direction) {
            int[] next = new int[] { pos[0] + d[0], pos[1] + d[1] };
            if (0 <= next[0] && next[0] < m && 0 <= next[1] && next[1] < n && grid[next[0]][next[1]] == 1) {
                q.add(new int[] { next[0], next[1] });
                grid[next[0]][next[1]] = 2;
                fresh--;
            }
        }
    }
}
