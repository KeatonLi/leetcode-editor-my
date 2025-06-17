package leetcode.editor.cn;

import java.util.Arrays;

class 寻找右区间{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] clone = new int[n][2];
        for (int i = 0; i < n; i++) clone[i] = new int[]{intervals[i][0], i};
        Arrays.sort(clone, (a,b)->a[0]-b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (clone[mid][0] >= intervals[i][1]) r = mid;
                else l = mid + 1;
            }
            ans[i] = clone[r][0] >= intervals[i][1] ? clone[r][1] : -1;
        }
        return ans;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}