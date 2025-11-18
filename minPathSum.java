class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 && i > 0) {
                    dp[j] += grid[i][j];  // only from top
                } else if (i == 0 && j > 0) {
                    dp[j] = dp[j - 1] + grid[i][j];  // only from left
                } else if (i > 0 && j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];  // min from top or left
                }
            }
        }
        return dp[n - 1];
    }
}
