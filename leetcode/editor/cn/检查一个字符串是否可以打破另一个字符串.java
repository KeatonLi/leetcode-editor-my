package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class 检查一个字符串是否可以打破另一个字符串{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s1.charAt(i) - 'a');
            list2.add(s2.charAt(i) - 'a');
        }
        list.sort(Comparator.comparingInt(a -> a));
        list2.sort(Comparator.comparingInt(a -> a));
//        System.out.println(list);
//        System.out.println(list2);
        boolean flag = true;
        boolean flag2 = true;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list2.get(i)) {
                flag2 = false;
            }
            if (list.get(i) < list2.get(i)) {
                flag = false;
            }
        }
//        System.out.println(flag + "---" + flag2);
        return flag || flag2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}