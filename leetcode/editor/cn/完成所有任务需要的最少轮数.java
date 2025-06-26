package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 完成所有任务需要的最少轮数{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return -1;
            } else {
                int x = entry.getValue() / 3;
                res += x;
                if (entry.getValue() % 3 == 1) {
                    res--;
                    res += 2;
                } else if (entry.getValue() % 3 == 2) {
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}