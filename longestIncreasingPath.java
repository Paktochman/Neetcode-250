class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }

    int dfs(int[][] mat, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int best = 1;

        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n && mat[x][y] > mat[i][j])
                best = Math.max(best, 1 + dfs(mat, x, y));
        }
        return dp[i][j] = best;
    }
}
