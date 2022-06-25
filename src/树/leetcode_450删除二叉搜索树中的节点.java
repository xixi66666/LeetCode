package 树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YangChenxi
 * 因为要求返回的是二叉搜索树，并不是平衡二叉树，所以要求没那么高,没有要求平衡因子
 * 同时注意二叉搜索树（bst）的性值：左子树的节点一定比根节点小，右子树的节点一定比根节点大
 * 怎么在删除后重新构建？还是根据性质
 * 1.删除的节点如果没有左/右子树，则返回有的那个子树
 * 2.如果都有的话，左子树的节点肯定比右子树的所有节点小，放在右子树的最左边的节点（最小的节点）的左子树上就行了。
 */
public class leetcode_450删除二叉搜索树中的节点 {
}
class Solution7 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val <key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
        }
        return root;
    }
}