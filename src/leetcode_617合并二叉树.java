/**
 * @author YangChenxi
 */
public class leetcode_617合并二叉树 {
}
class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }else if(root1 == null){
            return root2;
        } else if(root2 == null){
            return root1;
        }
        TreeNode merge = new TreeNode(root1.val+root2.val);
        merge.left = mergeTrees(root1.left,root2.left);
        merge.right = mergeTrees(root1.right,root2.right);
        return merge;
    }
}