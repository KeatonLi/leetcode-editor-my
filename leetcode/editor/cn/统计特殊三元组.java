package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 统计特殊三元组{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialTriplets(int[] nums) {
            final int MOD = (int) 1e9 + 7;
            Map<Integer, Integer> suf = new HashMap<>();
            for (int x : nums) {
                suf.merge(x, 1, Integer::sum);
            }

            long ans = 0;
            Map<Integer, Integer> pre = new HashMap<>();
            for (int x : nums) {
                suf.merge(x, -1, Integer::sum);
                ans += (long) pre.getOrDefault(x * 2, 0) * suf.getOrDefault(x * 2, 0);
                pre.merge(x, 1, Integer::sum);
            }
            return (int) (ans % MOD);
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}