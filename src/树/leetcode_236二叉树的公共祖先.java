package 树;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YangChenxi
 * 思路：
 * 先遍历一遍，存储所有节点的父亲节点。应该是使用map进行存储，因为要存节点和它对应的状态
 * 然后从p开始向上遍历，每遇到一个祖先节点就设置为true，然后从q遍历，遇到的第一个true就是深度最深的公共祖先节点
 */
public class leetcode_236二叉树的公共祖先 {
    public static void main(String[] args) {

    }
}
class Solution2 {
    HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        dfs(root);
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root.left != null){
            parentMap.put(root.left,root);
            dfs(root.left);
        }
        if(root.right != null){
            parentMap.put(root.right,root);
            dfs(root.right);
        }

    }

}