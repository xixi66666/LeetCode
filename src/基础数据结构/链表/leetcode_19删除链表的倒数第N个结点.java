package 基础数据结构.链表;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-09
 */
public class leetcode_19删除链表的倒数第N个结点 {
}
// 相当的丑陋啊

class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = new ListNode();
        cur = head;
        int sumNum = 0;
        if (head != null) {
            sumNum = 1;
        }


        while (cur.next != null) {
            sumNum++;
            cur = cur.next;
        }


        if (sumNum == 1) {
            return null;
        }
        if(sumNum - n == 0){
            return head.next;
        }
        cur = head;
        for (int i = 1; i <= sumNum; i++) {
            if (i == sumNum - n) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}