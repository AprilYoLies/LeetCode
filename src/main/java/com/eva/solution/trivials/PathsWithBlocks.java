package com.eva.solution.trivials;

public class PathsWithBlocks {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        if (obstacleGrid[i][j] == 1)
                            return 0;
                        dp[i][j] = 1;
                    } else {
                        if (obstacleGrid[i][j] == 1) {
                            dp[i][j] = 0;
                        } else {
                            if (i == 0) {
                                dp[i][j] = dp[i][j - 1];
                            } else {
                                dp[i][j] = dp[i - 1][j];
                            }
                        }
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
