package leetcode.editor.cn;

import java.util.*;

class 相邻字符串之间的最长公共前缀{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] longestCommonPrefix(String[] words) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Map<Integer, Integer> gapMap = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String cur = words[i];
            String word = words[i + 1];
            int close = getPrefixLength(cur, word);
//            System.out.println("i ==" + i + " close =  " + close);
            queue.offer(new int[]{close, i});
            if (i + 2 < n) {
                String next = words[i + 2];
                int gap = getPrefixLength(cur, next);
                gapMap.put(i, gap);
            }
        }

//        System.out.println(gapMap);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.max(res[i], gapMap.getOrDefault(i - 1, 0));
            if (queue.peek() == null) continue;
            if (queue.peek()[1] != i && queue.peek()[1] != i - 1) {
                res[i] = Math.max(res[i], queue.peek()[0]);
            } else {
                int[] poll1 = queue.poll();
                if (queue.peek() == null) {
                    queue.offer(poll1);
                    continue;
                }
                if (queue.peek()[1] == i - 1 || queue.peek()[1] == i) {
                    int[] poll2 = queue.poll();
                    if (queue.peek() == null) {
                        queue.offer(poll2);
                        queue.offer(poll1);
                        continue;
                    }
                    res[i] = Math.max(res[i], queue.peek()[0]);
                    queue.offer(poll2);
                    queue.offer(poll1);
                } else {
                    res[i] = Math.max(res[i], queue.peek()[0]);
                    queue.offer(poll1);
                }

            }
//            System.out.println("i = " + i + " result = " + gapMap.getOrDefault(i - 1, 0));
        }
        return res;
    }

    private int getPrefixLength(String cur, String word) {
        int i = 0;
        while (i < cur.length() && i < word.length() && cur.charAt(i) == word.charAt(i)) {
            i++;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}