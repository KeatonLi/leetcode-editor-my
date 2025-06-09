package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 检查是否所有字符出现次数相同{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<String, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(String.valueOf(c), counter.getOrDefault(String.valueOf(c), 0) + 1);
        }
        int count = counter.get(String.valueOf(s.charAt(0)));
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() != count) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}