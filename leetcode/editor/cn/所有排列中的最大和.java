package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class 所有排列中的最大和{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int mod = (int)1e9 + 7;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int[] request : requests) {
            prefix[request[0]]++;
            prefix[request[1] + 1]--;
        }
        int sum = 0;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            sum += prefix[i];
            queue1.offer(sum);
            queue2.offer(nums[i]);
        }
        int res = 0;
        while (!queue1.isEmpty()) {
            res += ((long) queue1.poll() * (long) queue2.poll()) % mod;
            res = res % mod;
        }
        return res;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}