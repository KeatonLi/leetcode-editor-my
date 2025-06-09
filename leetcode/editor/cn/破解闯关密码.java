package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class 破解闯关密码{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String crackPassword(int[] password) {
        int n = password.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(password[i]));
        }
        list.sort((a, b) -> (a + b).compareTo((b + a)));
        return String.join("", list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}