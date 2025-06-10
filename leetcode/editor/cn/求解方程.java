package leetcode.editor.cn;

class 求解方程{

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];

        int[] leftCoefficients = parseExpression(left);
        int[] rightCoefficients = parseExpression(right);

        int xCoeffDiff = leftCoefficients[0] - rightCoefficients[0];
        int constDiff = rightCoefficients[1] - leftCoefficients[1];

        if (xCoeffDiff == 0 && constDiff == 0) {
            return "Infinite solutions";
        }
        
        if (xCoeffDiff == 0) {
            return "No solution";
        }
        
        return "x=" + (constDiff / xCoeffDiff);
    }

    private int[] parseExpression(String expression) {
        int xCoefficient = 0;
        int constantTerm = 0;
        
        int sign = 1;
        int i = 0;
        
        while (i < expression.length()) {
            char c = expression.charAt(i);
            
            if (c == '+') {
                sign = 1;
                i++;
            } else if (c == '-') {
                sign = -1;
                i++;
            }
            
            int num = 0;
            boolean hasDigit = false;
            
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
                hasDigit = true;
            }
            
            if (i < expression.length() && expression.charAt(i) == 'x') {
                if (hasDigit) {
                    xCoefficient += sign * num;
                } else {
                    xCoefficient += sign * 1;
                }
                i++;
            } else {
                constantTerm += sign * num;
            }
        }
        
        return new int[] {xCoefficient, constantTerm};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}