package kama;

import java.util.Arrays;

/**
 * 给你一个大小为 n 的整数数组 nums，其中只包含 1 和 -1，以及一个整数 k。
 *
 * 你可以最多进行 k 次以下操作：
 *
 * 选择一个下标 i（0 <= i < n - 1），然后将 nums[i] 和 nums[i + 1] 同时 乘以 -1。
 *
 * 注意：你可以在 不同 的操作中多次选择相同的下标 i。
 *
 * 如果在最多 k 次操作后可以使数组的所有元素相等，则返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入： nums = [1,-1,1,-1,1], k = 3
 *
 * 输出： true
 *
 * 解释：
 *
 * 我们可以通过以下两次操作使数组的所有元素相等：
 *
 * 选择下标 i = 1，将 nums[1] 和 nums[2] 同时乘以 -1。此时 nums = [1,1,-1,-1,1]。
 * 选择下标 i = 2，将 nums[2] 和 nums[3] 同时乘以 -1。此时 nums = [1,1,1,1,1]。
 * 示例 2：
 *
 * 输入： nums = [-1,-1,-1,1,1,1], k = 5
 *
 * 输出： false
 *
 * 解释：
 *
 * 在最多 5 次操作内，无法使数组的所有元素相等。
 *
 *
 *
 * 提示：
 *
 * 1 <= n == nums.length <= 105
 * nums[i] 的值为 -1 或 1。
 * 1 <= k <= n
 */

public class T2 {

    static class Solution {
        public boolean canMakeEqual(int[] nums, int k) {
            int n = nums.length;
            int[] newNums = Arrays.copyOf(nums, n);
            int[] newNums2 = Arrays.copyOf(nums, n);
            return check(newNums, k, 1) || check(newNums2, k, -1);
        }

        private boolean check(int[] nums, int k, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1 && nums[i] != target) {
                    return false;
                }
                if (nums[i] != target) {
                    nums[i] *= (-1);
                    nums[i + 1] *= (-1);

                    k--;
                    if (k < 0) {
                        return false;
                    }
                }
//                System.out.println(Arrays.toString(nums));
            }
            return true;
        }
    }

    public static void main(String[] args) {
        // 测试用例
        Solution solution = new Solution();
        System.out.println(solution.canMakeEqual(new int[]{1, -1, 1, -1, 1}, 3)); // 输出: true
        System.out.println(solution.canMakeEqual(new int[]{-1, -1, -1, 1, 1, 1}, 5)); // 输出: false
    }
}