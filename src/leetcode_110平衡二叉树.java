/**
 * @program: LeetCode
 * @description: 平衡二叉树
 * @author: 杨晨曦
 * @create: 2022-06-25 18:01
 **/
public class leetcode_110平衡二叉树 {

}
class Solution110 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
}