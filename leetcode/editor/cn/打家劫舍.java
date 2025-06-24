package leetcode.editor.cn;

class 打家劫舍{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return rob(nums, 0, nums.length - 1, nums.length);
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