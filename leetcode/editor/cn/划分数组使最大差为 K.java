package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 划分数组使最大差为 K{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int partitionArray(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int lastNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] - lastNum > k) {
                res++;
                lastNum = nums[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}