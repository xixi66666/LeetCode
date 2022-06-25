package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author YangChenxi
 */
public class leetcode_199二叉树的右视图 {
}
class Solution3 {
    List<Integer> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return ans;
        }
        bfs(root);
       return ans;
    }

    public void bfs(TreeNode root){
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(i == len-1){
                    ans.add(node.val);
                }
            }
        }
    }
}