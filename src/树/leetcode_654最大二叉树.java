package 树;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author YangChenxi
 */
public class leetcode_654最大二叉树 {

}
class Solution14 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length);
    }
    public TreeNode buildTree(int[] nums,int left,int right){
        if(left >= right){
            return null;
        }
        int number = max(nums,left,right);
        System.out.println(number);
        TreeNode node = new TreeNode(nums[number]);
        node.left = buildTree(nums,left,number);
        node.right = buildTree(nums,number+1,right);
        return node;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}
