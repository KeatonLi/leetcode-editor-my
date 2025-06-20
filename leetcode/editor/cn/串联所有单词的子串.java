package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class 串联所有单词的子串 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int m = words.length, n = words[0].length();
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            int size = s.length();

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i <= size - m * n; i++) {
                Map<String, Integer> tmp = new HashMap<>();
//                System.out.println("startIndex如下" + i);
                String allStr = s.substring(i, i + m * n);
                for (int j = 0; j < m * n; j += n) {
                    String subStr = allStr.substring(j, j + n);
//                    System.out.println(subStr);
                    tmp.put(subStr, tmp.getOrDefault(subStr, 0) + 1);

                }
                if (map.equals(tmp)) res.add(i);

            }

            return res;

        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}