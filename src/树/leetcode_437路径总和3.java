package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_437路径总和3 {
}
class Solution8 {
    int count = 0;
    List<TreeNode> list = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        preOrder(root,targetSum,0);
        count = 0;
        int size = list.size();
        for(int i = 0;i<size;i++){
            System.out.println("-------------------------------");
            preOrder(list.get(i),targetSum,0);
        }
        return count;
    }
        public void preOrder (TreeNode root ,int target, int sum){
            if (root == null) {
                return;
            }
            list.add(root);
            sum += root.val;
            System.out.println("sum : " + sum);
            if (sum == target) {
                count++;
            }
            preOrder(root.left, target, sum);
            preOrder(root.right, target, sum);
            sum -= root.val;
        }
    }