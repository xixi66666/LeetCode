package 基础数据结构.链表;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-17
 */
public class leetcode_206反转链表 {
}
/*
重要的是画图清晰思路
curr.next = pre;  这行代码的改变链表指向是关键
 */

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode curr = head;
        while(curr.next != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = pre;
        return curr;
    }
}