package leetcode.editor.cn;

class 增量元素之间的最大差值{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int maxNum = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            maxNum = Math.max(maxNum, nums[i]);
            max[i] = maxNum;
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (max[i] > nums[i]) {
                res = Math.max(res, max[i] - nums[i]);
            }
        }
        return res;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}