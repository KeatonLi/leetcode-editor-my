package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class K 个一组翻转链表{

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
    public ListNode reverseKGroup(ListNode head, int k) {

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            List<ListNode> tempList = new ArrayList<>();
//            System.out.println(cur.val);
            i = 0;
            while (i < k && cur != null) {
                tempList.add(cur);
                cur = cur.next;
                i++;
            }
            if (i == k) {
                Collections.reverse(tempList);
            }

            list.addAll(tempList);
        }



        for (int j = 0; j < list.size() - 1; j++) {
            list.get(j).next = list.get(j + 1);;
        }
        list.get(list.size() - 1).next = null;
//        System.out.println(list.size());
        return list.get(0);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}