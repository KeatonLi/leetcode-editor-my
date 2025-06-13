package leetcode.editor.cn;

import java.util.*;

class 找出最长等值子数组 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
            }

            int maxLen = 0;

            for (List<Integer> positions : map.values()) {
                int left = 0;

                for (int right = 0; right < positions.size(); right++) {
                    while ((positions.get(right) - positions.get(left) + 1) - (right - left + 1) > k) {
                        left++;
                    }
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
            
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}