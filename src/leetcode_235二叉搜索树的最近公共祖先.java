import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChenxi
 */
public class leetcode_235二叉搜索树的最近公共祖先 {
}
class Solution235 {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            dfs(root);
            while(p != null){
                set.add(p);
                p = map.get(p);
            }
            while(q != null){
                if(set.contains(q)){
                    return q;
                }else{
                    q = map.get(q);
                }
            }
            return null;
        }
        public void dfs(TreeNode root){
            if(root == null){
                return;
            }
            if(root.left != null){
                map.put(root.left,root);
                dfs(root.left);
            }
            if(root.right != null){
                map.put(root.right,root);
                dfs(root.right);
            }
        }
}