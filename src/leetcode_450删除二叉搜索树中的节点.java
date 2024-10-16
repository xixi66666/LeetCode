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
class Solution450 {
    /*
    方法一，会增加树的高度
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val <key){
            root.right = deleteNode(root.right,key);
        }else{
            //如果左子树为空，返回右子树
            if(root.left == null){
                return root.right;
            }
            //如果右子树为空，返回左子树
            if (root.right == null){
                return root.left;
            }
            //左子树的节点肯定比右子树的所有节点小，放在右子树的最左边的节点（最小的节点）的左子树上就行了
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
        }
        return root;
    }
    /*
    方法二，会保持二叉搜索树
     */
    private int getNextValue(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private int getPrevValue(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) { // 当前节点的值大于 key，去左子树上寻找待删除的点
            root.left = deleteNode1(root.left, key);
        } else if (root.val < key) { // 当前节点的值小于 key，去右子树上寻找待删除的点
            root.right = deleteNode1(root.right, key);
        } else { // 当前节点为待删除的节点
            if (root.left == null && root.right == null) {
                // 1. 如果当前节点是叶子节点，直接删除
                root = null;
            } else if (root.right != null) {
                // 2. 如果当前节点的右子树存在，用下一节点（右子树的最左节点）替换当前节点，并在右子树上删除下一个节点
                root.val = getNextValue(root); // 用下一节点（右子树的最左节点）替换当前节点
                root.right = deleteNode1(root.right, root.val); // 去右子树上将下一个节点删除
            } else {
                // 3. 当前节点的右子树不存在，但是左子树存在时，用上一个节点（左子树最右的节点）替换当前节点，并在左子树上删除上一个节点
                root.val = getPrevValue(root);
                root.left = deleteNode1(root.left, root.val);
            }

        }
        return root;
    }

}