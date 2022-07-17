package 树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_98验证二叉树 {
}
/*
二叉搜索树中序遍历就是升序啊，这都想不到的吗，这两天脑子咋了？？？
 */
class Solution17 {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        order(root);
        System.out.println(list.toString());
        for(int i = 0;i< list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;

    }
    public void order(TreeNode node){
        if(node == null){
            return;
        }
        order(node.left);
        list.add(node.val);
        order(node.right);
    }
}
