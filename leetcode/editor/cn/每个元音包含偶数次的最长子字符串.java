package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 每个元音包含偶数次的最长子字符串 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestSubstring(String s) {
            int n = s.length();
            boolean[] isVowel = new boolean[5];
            Arrays.fill(isVowel, true);
            Map<String, Integer> map = new HashMap<>();
            int res = 0;
            map.put(Arrays.toString(isVowel), 0);
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'a') {
                    isVowel[0] = !isVowel[0];
                } else if (c == 'e') {
                    isVowel[1] = !isVowel[1];
                } else if (c == 'i') {
                    isVowel[2] = !isVowel[2];
                } else if (c == 'o') {
                    isVowel[3] = !isVowel[3];
                } else if (c == 'u') {
                    isVowel[4] = !isVowel[4];
                }
                String key = Arrays.toString(isVowel);
                if (map.containsKey(key)) {
                    res = Math.max(res, i + 1 - map.get(key));
                } else {
                    map.put(key, i + 1);
                }
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}