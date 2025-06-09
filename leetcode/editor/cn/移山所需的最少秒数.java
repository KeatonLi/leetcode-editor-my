package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

class 移山所需的最少秒数{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            int n = workerTimes.length;

            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

            for (int i = 0; i < n; i++) {
                int base = workerTimes[i];
                pq.offer(new long[]{base, i, 1, base});
            }

            while (mountainHeight-- > 0) {
                long[] cur = pq.poll();
                long nextTime = cur[0];
                long index = cur[1];
                long count = cur[2];
                long base = cur[3];

                if (mountainHeight == 0) {
                    return nextTime;
                }

                long nextNextTime = nextTime + base * (count + 1);
                pq.offer(new long[]{nextNextTime, index, count + 1, base});
            }

            return 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}