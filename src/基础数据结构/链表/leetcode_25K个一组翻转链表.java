package 基础数据结构.链表;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-16
 */
public class leetcode_25K个一组翻转链表 {
}


class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode count = head;
        int num = 0;
        while(count != null){
            num++;
            count = count.next;
        }
        int reverseNum = num / k;
        ListNode ans = new ListNode();
        ListNode ret = ans;
        ans.next = head;
        ListNode first = head;
        for(int i = 0;i<reverseNum;i++){
            for(int j = 0;j<k-1;j++){
                ans.next = first.next;
            }
        }
        return ret;
    }
}