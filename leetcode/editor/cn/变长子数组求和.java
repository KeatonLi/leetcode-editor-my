package leetcode.editor.cn;

import java.util.Arrays;

class 变长子数组求和{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int res = 0;
//        System.out.println(Arrays.toString(prefixSum));
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
//            System.out.println(start);
            res += (prefixSum[i + 1] - prefixSum[start]);

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}