package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

class 最大平均值和的分组{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int k) {
            int n = nums.length;
            double[] preSum = new double[n + 1];
            double[][] dp = new double[n][k + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], 0);
            }
//            System.out.println(Arrays.deepToString(dp));
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                dp[i - 1][1] = preSum[i] / i;
            }
            for (int i = 1; i < k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int l = j - 1; l > 0; l--) {
                        dp[j - 1][i + 1] = Math.max(dp[j - 1][i + 1], dp[l - 1][i] + (preSum[j] - preSum[l]) / (j - l));
                    }
                }
            }
//            System.out.println(Arrays.toString(preSum));
//            System.out.println(Arrays.deepToString(dp));
            return dp[n - 1][k];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        最大平均值和的分组 solution = new 最大平均值和的分组();
        最大平均值和的分组.Solution solution1 = solution.new Solution();
        System.out.println(solution1.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }
}