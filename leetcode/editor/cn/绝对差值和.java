package leetcode.editor.cn;

import java.util.Arrays;

class 绝对差值和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int MOD = (int) 1e9 + 7;

        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] clone = nums1.clone();
            Arrays.sort(clone);
            long sum = 0;
            long max = 0;
            for (int i = 0; i < n; i++) {
                int z = Math.abs(nums1[i] - nums2[i]);
                sum = (sum + z);
                int l = 0, r = n - 1;
                int target = nums2[i];
                while (l < r) {
                    int mid = (l + r + 1) / 2;
                    if (clone[mid] <= target) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                int nd = Math.abs(clone[r] - target);
                if (r + 1 < n) {
                    nd = Math.min(nd, Math.abs(clone[r + 1] - target));
                }
//            System.out.println(clone[l]);
//            System.out.println(clone[r]);
                if (nd < z) {
                    max = Math.max(max, z - nd);
                }
            }
            return (int) ((sum - max) % MOD);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}