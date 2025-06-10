package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class 奇偶频次间的最大差值I{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDifference(String s) {
            int n = s.length();
            Map<Character, Integer> map =  new HashMap<>();
            char[] charArray = s.toCharArray();
            for (int i = 0 ; i < n; i++) {
                char c = charArray[i];
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (char c : map.keySet()) {
                if (map.get(c) % 2 == 0) {
                    min = Math.min(min, map.get(c));
                } else {
                    max = Math.max(max, map.get(c));
                }
            }

            return max - min;



        }
}
//leetcode submit region end(Prohibit modification and deletion)

}