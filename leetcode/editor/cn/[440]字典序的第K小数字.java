package leetcode.editor.cn;//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。
//
//
//
// 示例 1:
//
//
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
//
//
// 示例 2:
//
//
//输入: n = 1, k = 1
//输出: 1
//
//
//
//
// 提示:
//
//
// 1 <= k <= n <= 10⁹
//
//
// Related Topics 字典树 👍 608 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // 第一个节点就是 curr，所以减少一次计数
        while (k > 0) {
            int count = countPrefix(curr, curr + 1, n);
            if (count <= k) {
                k -= count;
                curr++; // 移动到右边兄弟节点
            } else {
                curr *= 10; // 进入下一层
                k--;
            }
        }
        return curr;
    }

    private int countPrefix(long prefix, long next, long n) {
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, next) - prefix;
            prefix *= 10;
            next *= 10;
        }
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
