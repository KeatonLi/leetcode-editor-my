package leetcode.editor.cn;

import java.util.PriorityQueue;

class 两个数字的最大乘积{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < s.length(); i++) {
            pq.offer(s.charAt(i) - '0');
        }
        return pq.poll() * pq.poll();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}