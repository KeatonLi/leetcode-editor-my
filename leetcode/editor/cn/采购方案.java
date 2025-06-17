package leetcode.editor.cn;

import java.util.Arrays;

class 采购方案 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            int mod = (int) 1e9 + 7;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int left = i, right = nums.length - 1;
                while (left < right) {
                    int mid = (left + right + 1) / 2;
                    if (nums[mid] + nums[i] <= target) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                ans = (ans + left - i) % mod;
                }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}