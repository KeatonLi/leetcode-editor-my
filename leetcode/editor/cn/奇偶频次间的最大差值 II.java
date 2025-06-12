package leetcode.editor.cn;

class 奇偶频次间的最大差值 II{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDifference(String s, int k) {
            int n = s.length();
            int ans = -40000;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int[] prefixRight = new int[5];
                    int[] prefixLeft = new int[5];
                    int[][] max = new int[][]{{-40000, -40000}, {-40000, -40000}};
                    for (int l = 0, m = 0; m < n; m++) {
                        int r = m + 1;
                        prefixRight[s.charAt(m) - '0']++;
                        while (r - l >= k && prefixRight[i] > prefixLeft[i] && prefixRight[j] > prefixLeft[j]) {
                            int z = prefixLeft[i] & 1;
                            int x = prefixLeft[j] & 1;
                            max[z][x] = Math.max(max[z][x], prefixLeft[j] - prefixLeft[i]);
                            prefixLeft[s.charAt(l) - '0']++;
                            l++;
                        }
                        ans = Math.max(ans, prefixRight[i] - prefixRight[j] + max[prefixRight[i] & 1 ^ 1][prefixRight[j] & 1]);
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}