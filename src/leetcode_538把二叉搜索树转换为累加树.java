/**
 * @author YangChenxi
 */
public class leetcode_538把二叉搜索树转换为累加树 {
}

class Solution538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        TreeNode ans = root;
        inOrder(root);
        return ans;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }
}