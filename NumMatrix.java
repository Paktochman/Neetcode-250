package Neetcode250;

public class NumMatrix {
    private int[][] prefixSum;

    // Constructor: precompute the 2D prefix sum
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1]; // extra row and column for easier calculation

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] 
                                  + prefixSum[i - 1][j] 
                                  + prefixSum[i][j - 1] 
                                  - prefixSum[i - 1][j - 1];
            }
        }
    }

    // Return sum of rectangle (row1,col1) to (row2,col2) in O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] 
               - prefixSum[row1][col2 + 1] 
               - prefixSum[row2 + 1][col1] 
               + prefixSum[row1][col1];
    }

    // Test example
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        NumMatrix nm = new NumMatrix(matrix);
        System.out.println(nm.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(nm.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(nm.sumRegion(1, 2, 2, 4)); // 12
    }
}

