public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1) 水平翻转：每行左右镜像
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }

        // 2) 沿次对角线翻转：对称于 i+j = n-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {   // 只需遍历次对角线"上方"的元素
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }


    }
}
