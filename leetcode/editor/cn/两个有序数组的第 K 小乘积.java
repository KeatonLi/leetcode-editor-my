package leetcode.editor.cn;

class 两个有序数组的第 K 小乘积 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            int m = nums1.length;
            int n = nums2.length;
            long left = -10000000000L;
            long right = 10000000000L;
            while (left < right) {
                long mid = left + right >> 1;
                if (count(nums1, nums2, mid) >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }

        // 统计小于等于sum的乘积对数量
        private long count(int[] nums1, int[] nums2, long sum) {
            long number = 0;
            for (int i = 0; i < nums1.length; i++) {
                number += getCount(nums1[i], nums2, sum);
            }
//            System.out.println("sum = " + sum + "," + "num = " + number);
            return number;
        }

        // 统计 nums2中小于等于 sum的元素数量
        private int getCount(int num, int[] nums2, long sum) {
            int n = nums2.length;
            int left = 0;
            int right = n - 1;
            if (num > 0) {
                while (left < right) {
                    int mid = left + right + 1 >> 1;
                    if ((long) num * nums2[mid] <= sum) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if ((long) num * nums2[left] <= sum) {
                    return left + 1;
                } else {
                    return 0;
                }
            } else {
                while (left < right) {
                    int mid = left + right >> 1;
                    if ((long) num * nums2[mid] <= sum) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if ((long) num * nums2[left] <= sum) {
                    return n - left;
                } else {
                    return 0;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}