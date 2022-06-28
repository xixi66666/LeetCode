package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 503
 * @author: 杨晨曦
 * @create: 2022-06-26 01:38
 **/
/*
感觉是用bfs的
 */
public class leetcode_513找树左下角的值 {

}

class Solution11 {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                TreeNode node = queue.poll();
                if(node.right != null){
                    queue.add(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                ans = node.val;
            }
        }
        return ans;
    }

}