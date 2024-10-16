/**
 * @program: LeetCode
 * @description: 404
 * @author: 杨晨曦
 * @create: 2022-06-26 01:14
 **/
public class leetcode_404左叶子之和 {

}
/*
1.找到所有的左子树叶子节点
2.相加
 */
class Solution404 {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? order(root,true):0;

    }
    public int order(TreeNode root,boolean flag){
        if(root == null){
            return 0;
        }
        order(root.left,true);
        if(root.left == null && root.right == null ){
            if(flag == true)
            ans += root.val;
            System.out.println(ans);
        }
        order(root.right,false);
        return ans;
    }

}