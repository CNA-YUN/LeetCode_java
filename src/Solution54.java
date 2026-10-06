import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int d = 0;
        int x = 0, y = 0;
        for (int index = 0; index < row * col; index++) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            int nextx = x + direction[d][0], nexty = y + direction[d][1];
            if (nextx < 0 || nextx >= row || nexty < 0 || nexty >= col || visited[nextx][nexty]) {
                d = (d + 1) % 4;
            }
            x += direction[d][0];
            y += direction[d][1];
        }
        return res;
    }

}

