package leetcode.editor.cn;

import java.util.Arrays;

class 打家劫舍 II{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2 || n == 3) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return Math.max(rob(nums, 0, n - 2, n),
                rob(nums, 1, n - 1, n));
    }

    private int rob(int[] nums, int startIndex, int endIndex, int n) {
        int[] dp = new int[n];
        dp[startIndex] = nums[startIndex];
        dp[startIndex + 1] = Math.max(nums[startIndex], nums[startIndex + 1]);
        for (int i = startIndex + 2; i <= endIndex; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[endIndex];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}