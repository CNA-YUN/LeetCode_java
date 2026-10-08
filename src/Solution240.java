public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int x = 0, y = matrix[0].length - 1;
        while (x <= rows && y >= 0) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) y--;
            else x++;
        }
        return false;
    }
}
