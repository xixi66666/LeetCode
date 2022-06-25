package 树;


import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_113路经总合2 {
    public static void main(String[] args) {

    }
}
class Solution1 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return ans;
        }
        preOrder(root,targetSum);
        return ans;
    }

    public void preOrder(TreeNode root, int target){
        if(root == null){
            return;
        }
        sum += root.val;
        t.add(sum);
        if(sum == target && root.left == null && root.right == null){
            ans.add(new ArrayList(t));
            return;
        }
        preOrder(root.left,target);
        sum -= root.val;
        preOrder(root.right,target);
    }
}
