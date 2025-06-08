package daily;

import java.util.ArrayList;
import java.util.List;

class T1 {
    public static class Solution {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(i, n, res);
            }
            return res;
        }


        public void dfs(int cur, int n, List<Integer> res) {
            if (cur > n) return;
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                dfs(cur * 10 + i, n, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.lexicalOrder(13);
        System.out.println(integers);
    }

}