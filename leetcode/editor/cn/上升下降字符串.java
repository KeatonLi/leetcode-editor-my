package leetcode.editor.cn;

class 上升下降字符串{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}