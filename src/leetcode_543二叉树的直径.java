/**
 * @author YangChenxi
 */
public class leetcode_543二叉树的直径 {
}
class Solution543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        order(root);
        return ans;
    }
    public int order(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int L = order(treeNode.left);
        int R = order(treeNode.right);
        ans = Math.max(ans,L+R);
        return Math.max(L,R) + 1;
    }
}