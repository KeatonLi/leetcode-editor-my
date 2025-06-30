package leetcode.editor.cn;

import java.util.Arrays;

class 划分数组得到最小 XOR {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minXor(int[] nums, int k) {
            int n = nums.length;
            int[][] f = new int[k + 1][n + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE);
            f[0][0] = 0;
            for (int i = 1; i <= k; i++) {
                for (int j = i; j <= n - (k - i); j++) {
                    int res = Integer.MAX_VALUE;
                    int s = 0;
                    for (int l = j - 1; l >= i - 1; l--) {
                        s ^= nums[l];
                        res = Math.min(res, Math.max(f[i - 1][l], s));
                    }
                    f[i][j] = res;
                }
            }
            return f[k][n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}