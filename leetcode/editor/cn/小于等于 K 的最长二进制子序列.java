package leetcode.editor.cn;

class 小于等于 K 的最长二进制子序列{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                for (int j = i + 1; j <= n; j++) {
                    String substring = s.substring(i, j);
//                    System.out.println(substring);
//                    System.out.println(Integer.parseInt(substring, 2));
//                    System.out.println("====");
                    if (Integer.parseInt(substring, 2) <= k) {
                        res = Math.max(res, substring.length() + count);
                    } else {
                        break;
                    }
                }
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}