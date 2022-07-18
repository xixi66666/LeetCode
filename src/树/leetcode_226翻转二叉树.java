package 树;

/**
 * @author YangChenxi
 */
public class leetcode_226翻转二叉树 {
    public static void main(String[] args) {

    }
}
class Solution18 {
    TreeNode ans = new TreeNode();
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}