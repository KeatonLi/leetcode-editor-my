package leetcode.editor.cn;

import java.util.*;

class 打家劫舍 III {

    protected class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        Map<TreeNode, Integer> map = new HashMap<>();
        Map<TreeNode, Integer> g = new HashMap<>();
        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(map.getOrDefault(root, 0), g.getOrDefault(root, 0));
        }


        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);
            map.put(node, g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0) + node.val);
            g.put(node, Math.max(map.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(map.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}