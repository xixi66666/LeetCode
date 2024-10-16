/**
 * @program: LeetCode
 * @description:
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 注意看是逆序的，243变成342，所以尾插法就好了
 * @author: 杨晨曦
 * @create: 2023-07-25 20:39
 **/
public class leetcode_2两数相加 {

}
/*
1.首先，题目给的顺序比如243 加的时候是342，最后的结果807又要变成708，两次变化导致本身给的l1 l2 其实是正序，使用尾插法就可以解决。
2.判断L1 L2是否不都为null ，new一个number记录每个节点的数值，当L1或者L2不为null的时候加起来就行了，值得注意的是如果最后number大于10.减去10就行了并且最后number设置为1否则为0.
3.由于我们的判断规则为 while (l1 != null || l2 != null) 当出现最终结果进位的时候结果是错误的。很好解决：判断number最后的结果是不是1，如果是的话说明发生了进位，不是的话说明结果正确。
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode ret = listNode;
        int number = 0;
        if(l1.val == 0 && l2.val == 0){
            listNode.val = 0;
            return listNode;
        }
        while (l1 != null || l2 != null){
            if(l1 != null){
                number += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                number += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode();
            if(number >= 10){
                newNode.val = number-10;
                number = 1;
            }else {
                newNode.val = number;
                number = 0;
            }
            listNode.next = newNode;
            listNode = listNode.next;
        }
        if(number == 1){
            listNode.next = new ListNode(1);
        }
        return ret;
    }
}
