package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 * 怎么有点像二分法呢
 */

public class leetcode_1382将二叉搜索树变平衡 {
    public static void main(String[] args) {

    }
}
class Solution5 {
    //得到的list就是中序排列的，也就是从小到大排列的
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildTree(0,list.size()-1);
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
    private TreeNode buildTree(int start, int end) {
        if (start > end){
            return null;
        }
        // 中间节点为root
        int mid = start + (end - start >> 1);
        TreeNode root = list.get(mid);
        // 递归构造左右子树
        root.left = buildTree(start,mid-1);
        root.right = buildTree(mid+1,end);
        // 返回root
        return root;
    }
}