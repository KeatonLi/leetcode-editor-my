package leetcode.editor.cn;

class 循环数组中相邻元素的最大差值{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cur = i % n;
            int pre = (i - 1) % n;
            max = Math.max(max, Math.abs(nums[cur] - nums[pre]));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}