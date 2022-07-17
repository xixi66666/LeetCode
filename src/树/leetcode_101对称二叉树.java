package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author YangChenxi
 */
public class leetcode_101对称二叉树 {
    public static void main(String[] args) {

    }
}
/*
回溯
 */
class Solution15 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}