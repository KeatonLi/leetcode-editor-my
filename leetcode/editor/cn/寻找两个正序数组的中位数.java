package leetcode.editor.cn;

import java.util.PriorityQueue;

class 寻找两个正序数组的中位数{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            queue.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            queue.offer(nums2[i]);
        }
        for (int i = 0; i < (m + n); i++) {
            nums[i] = queue.poll();
        }
        if ((m + n) % 2 == 0) {
            return (nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2.0;
        } else {
            return nums[(m + n) / 2];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}