package leetcode.editor.cn;

class 填充特殊网格{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] specialGrid(int n) {
        int size = 1 << n;
        if (size == 0) {
            return new int[][]{{0}};
        }
        int[][] grid = new int[size][size];
        System.out.println((1 << (2 * n)) - 1);
        dfsSet(grid, 0, 0, size - 1, size - 1, ((1 << (2 * n)) - 1));
        return grid;
    }

    private void dfsSet(int[][] grid, int startX, int startY, int endX, int endY, int startNum) {
        int m = grid.length;
        int n = grid[0].length;
        if (startX == endX && startY == endY) {
            grid[startX][startY] = startNum;
            return;
        }
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        int sum = (midX - startX + 1) * (midY - startY + 1);
        dfsSet(grid, startX, startY, midX, midY, startNum);
        dfsSet(grid, midX + 1, startY, endX, midY, startNum - sum);
        dfsSet(grid, midX + 1, midY + 1, endX, endY, startNum - 2 * sum);
        dfsSet(grid, startX, midY + 1, midX, endY, startNum - 3 * sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}