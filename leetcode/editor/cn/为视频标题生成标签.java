package leetcode.editor.cn;

import java.util.Arrays;

class 为视频标题生成标签{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String generateTag(String caption) {
        String[] split = caption.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = split.length;
        sb.append("#");
        if (n == 0) {
            return "#";
        }
//        System.out.println(Arrays.toString(split));
        for (int i = 0; i < n; i++) {
            if (split[i].length() > 0) {
                sb.append(split[i].substring(0, 1).toUpperCase());
                sb.append(split[i].substring(1).toLowerCase());
            }
        }
//        System.out.println(sb.toString());
        if (sb.length() > 1) {
            sb.setCharAt(1, Character.toLowerCase(sb.charAt(1)));
        }
        return sb.substring(0, Math.min(sb.length(), 100)).toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}