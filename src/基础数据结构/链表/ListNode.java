package 基础数据结构.链表;

/**
 * @program: LeetCode
 * @description:
 * @author: 杨晨曦
 * @create: 2023-07-25 20:40
 **/
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }