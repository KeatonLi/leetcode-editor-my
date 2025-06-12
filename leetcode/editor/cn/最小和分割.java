package leetcode.editor.cn;

import java.util.PriorityQueue;

class 最小和分割 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitNum(int num) {
            String s = String.valueOf(num);
            int n = s.length();
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.offer(s.charAt(i));
            }
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sb1.append(pq.poll());
                } else {
                    sb2.append(pq.poll());
                }
            }
            int res = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}