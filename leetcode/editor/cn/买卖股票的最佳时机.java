package leetcode.editor.cn;

import java.util.PriorityQueue;

class 买卖股票的最佳时机{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            pq.offer(prices[i - 1]);
            if (pq.peek() < prices[i]) {
                res = Math.max(res, prices[i] - pq.peek());
            }
//            System.out.println(res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}