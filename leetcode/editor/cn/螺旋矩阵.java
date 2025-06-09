package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 螺旋矩阵{

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0) return res;

            int m = matrix.length, n = matrix[0].length;
            int top = 0, bottom = m - 1;
            int left = 0, right = n - 1;

            while (top <= bottom && left <= right) {
                // 从左到右
                for (int j = left; j <= right; j++) {
                    res.add(matrix[top][j]);
                }
                top++;

                // 从上到下
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;

                // 从右到左
                if (top <= bottom) {
                    for (int j = right; j >= left; j--) {
                        res.add(matrix[bottom][j]);
                    }
                    bottom--;
                }

                // 从下到上
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }

            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}