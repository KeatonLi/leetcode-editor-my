package leetcode.editor.cn;

import java.util.PriorityQueue;

class 合并 K 个升序链表{

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


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                while (node != null) {
//                    System.out.println(node.val);
                    pq.offer(node);
                    node = node.next;
                }
            }
//            System.out.println(pq.size());
            ListNode res = null;
            ListNode temp = null;
            boolean flag = false;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
//                System.out.println(node.val);
                if (!flag) {
                    res = node;
                    flag = true;
                }
                if (temp != null) {
                    temp.next = node;
                }
                temp = node;


            }
            if (temp != null) {
                temp.next = null;
            }
            return res;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}