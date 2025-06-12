package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class 矩阵中的最长递增路径{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        int m =  matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, m, n));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int maxLen = 1;
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, nextI, nextJ, m, n));
            }
        }
        memo[i][j] = maxLen;
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}