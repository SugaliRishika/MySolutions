class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = matrix[i][j];
                if (j - 1 >= 0) {
                    left += dp[i - 1][j - 1];
                } else {
                    left += (int) 1e9;
                }
                int right = matrix[i][j];
                if (j + 1 < m) {
                    right += dp[i - 1][j + 1];
                } else {
                    right += (int) 1e9;
                }

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }
        return mini;
    }
}
