package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

class 最小化数对的最大差值{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimizeMax(int[] nums, int p) {
            Arrays.sort(nums);
            int left = 0, right = nums[nums.length - 1] - nums[0];

            while (left < right) {
                int mid = (left + right) / 2;
                int count = 0;
                for (int i = 0; i < nums.length - 1; ) {
                    if (nums[i + 1] - nums[i] <= mid) {
                        count++;
                        i += 2;
                    } else {
                        i++;
                    }
                }
                if (count >= p) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

//runtime:17 ms
//memory:54.8 MB

//leetcode submit region end(Prohibit modification and deletion)

}