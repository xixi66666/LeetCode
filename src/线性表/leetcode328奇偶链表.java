package 线性表;

public class leetcode328奇偶链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        head[0] = node1;
//        head[1] = node2;
//        head[2] = node3;
//        head[3] = node4;
//        head[4] = node5;
        Solution1 solution1 = new Solution1();
        ListNode node = solution1.oddEvenList(node1);
        while (node!=null){
            //System.out.print(node.val);
            node = node.next;
        }

    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode cur = node1;
        ListNode cur2 = node2;
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        /*
        在循环里面进行指针移动，出现了一个问题就是最后一个的head的值无法在循环中就获取到，
        因为在循环中的 head = head.next; 执行完之后就进入了while循环中的判断，这时因为while里面是
        head = head.next;，所以一定是失败的，所以需要在跳出循环之后进行判断。
         */
        while(head != null && head.next != null && head.next.next != null){
            node1.next = head;
            node1 = node1.next;
            head = head.next;
            System.out.println("node1:" + node1.val);
            node2.next = head;
            head = head.next;
            node2 = node2.next;
            System.out.println("node2:" + node2.val);
        }
        /*
        跳出后有两种可能，一个是head有奇数个，一个是偶数个
        我觉得使用if判断head.next是否为空比较简单
         */
        if(head.next == null){
            node2.next = null;
            node1.next = head;
            head.next = cur2.next;
        }else{
            node1.next = head;
            node2.next = head.next;
            node1.next.next = cur2.next;
        }
        return cur.next;
    }
}