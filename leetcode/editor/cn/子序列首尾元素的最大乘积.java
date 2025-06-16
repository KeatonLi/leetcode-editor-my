package leetcode.editor.cn;

class 子序列首尾元素的最大乘积{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumProduct(int[] nums, int m) {
            long ans = Long.MIN_VALUE;
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int i = m - 1; i < nums.length; i++) {
                int y = nums[i - m + 1];
                mn = Math.min(mn, y);
                mx = Math.max(mx, y);
                long x = nums[i];
                ans = Math.max(ans, Math.max(x * mn, x * mx));
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}