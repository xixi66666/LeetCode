package 基础数据结构.链表;

import java.util.List;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-12
 */
public class leetcode_21合并两个有序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode node2 = new ListNode(1,new ListNode(3,new ListNode(5)));
        Solution21 solution21 = new Solution21();
        ListNode node = solution21.mergeTwoLists(node1, node2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
/*
仔细判断 到底是 node 还是 node.next
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int num = 0;
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        node1 = list1;
        node2 = list2;

        ListNode ans = new ListNode();
        ListNode ret = ans;
        while(node1 != null || node2 != null){
            if(node1 != null && node2 != null){
                if(node1.val <= node2.val){
                    ans.next = node1;
                    ans = ans.next;
                    node1 = node1.next;
                }else{
                    ans.next = node2;
                    ans = ans.next;
                    node2 = node2.next;
                }
            } else if (node1 == null && node2 != null) {
                ans.next = node2;
                return ret.next;

            }else if (node1 != null && node2 == null){
                ans.next = node1;
                return ret.next;

            }


        }
        return ret.next;
    }
}
