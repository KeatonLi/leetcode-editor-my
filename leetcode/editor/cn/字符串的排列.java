package leetcode.editor.cn;

import java.util.Arrays;

class 字符串的排列{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (int i = 0; i < m; i++) {
            countS1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            countS2[s2.charAt(i) - 'a']++;
            if (i >= m) {
                countS2[s2.charAt(i - m) - 'a']--;
            }
            if (Arrays.equals(countS1, countS2)) {
                return true;
            }
        }
        return false;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}