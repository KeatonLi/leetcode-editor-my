package leetcode.editor.cn;

import java.util.Arrays;

class 划分数组并满足最大差限制{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int x = n / 3;
        int[][] res = new int[x][3];
        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            for (int j = 0; j < 3; j++) {
                res[i / 3][j] = nums[i + j];
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}