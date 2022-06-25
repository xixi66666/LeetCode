package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_114二叉树展开为链表 {

}
class Solution4 {
        List<TreeNode> list = new ArrayList<>();
        public void flatten(TreeNode root) {
            if(root != null){
                preOrder(root);
                int len = list.size();
                root = list.get(0);
                for(int i = 0;i<len-1;i++){
                    root.left = null;
                    root.right = list.get(i+1);
                    root = root.right;
                }
            }

        }

        public void preOrder(TreeNode root){
            if(root == null){
                return;
            }

            list.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }

}