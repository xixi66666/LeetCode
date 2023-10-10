package 树;

/**
 * @program: LeetCode
 * @description: 100
 * @author: 杨晨曦
 * @create: 2023-01-02 22:06
 **/
public class leetcode_100相同的树 {

}
/*
采用递归的方法，分几种情况讨论：
1.两个节点都为null
2.两个节点都有值
3.一个为空一个不为空
 */
class Solution21 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}