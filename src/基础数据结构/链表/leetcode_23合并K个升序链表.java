package 基础数据结构.链表;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-16
 */
public class leetcode_23合并K个升序链表 {
}
/*
投机取巧的方法
 */

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode listNode : lists){
            ListNode start = listNode;
            while(start != null){
                list.add(start.val);
                start = start.next;
            }
        }
        Collections.sort(list);
        ListNode ans = new ListNode();
        ListNode ret = ans;
        for(int n : list){
            ans.next = new ListNode(n);
            ans = ans.next;
        }
        return ret.next;
    }
}
