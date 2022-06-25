package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_257二叉树的所有路径 {
}
class Solution9 {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        order(root,"");
        return ans;
    }
    public void order(TreeNode root,String string){
        if(root == null){
            return;
        }
        string += String.valueOf(root.val);
        if(root.left == null && root.right== null){
            ans.add(string);
        }
        string += "->";
        order(root.left,string);
        order(root.right,string);
        string.replace(String.valueOf(root.val),"");
    }
}
