package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class 分割字符串{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> partitionString(String s) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.substring(i, i + 1));
            String tmp = sb.toString();
            if (!set.contains(tmp)) {
                set.add(tmp);
                res.add(tmp);
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}