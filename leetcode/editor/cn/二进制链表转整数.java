package leetcode.editor.cn;




class 二进制链表转整数{

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int[] nums = new int[32];
        int z = 0, length = 0;
        while (head != null) {
            nums[z] = head.val;
            z++;
            length++;
            head = head.next;
        }
        int num = 0;
        for (int i = 0; i < length; i++) {
            num += nums[i] << (length - i - 1);
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}