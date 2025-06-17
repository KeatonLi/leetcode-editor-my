package leetcode.editor.cn;

import java.util.Arrays;

class 将数组按照奇偶性转化{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] & 1;
        }
        Arrays.sort(nums);
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}