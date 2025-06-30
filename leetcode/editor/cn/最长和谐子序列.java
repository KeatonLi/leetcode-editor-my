package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 最长和谐子序列{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = map.getOrDefault(nums[i], 0);
            int tmp1 = map.getOrDefault(nums[i] + 1, 0);
            int tmp2 = map.getOrDefault(nums[i] - 1, 0);
            if (tmp1 == 0 && tmp2 == 0) tmp = 0;
            res = Math.max(res, Math.max(tmp1 + tmp, tmp2 + tmp));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}