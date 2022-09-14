import java.math.BigInteger;
import java.util.*;

/**
 * @author YangChenxi
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger(String.valueOf(0));
        bigInteger.add(new BigInteger(String.valueOf(1)));
        System.out.println(bigInteger.toString());
        int loop = scanner.nextInt();
        int r  = scanner.nextInt();
        TreeNode1 root = new TreeNode1();
        Map<Integer,TreeNode1> map = new HashMap<>();
        for(int i = 0;i<loop;i++){
            int n = scanner.nextInt();
            if(n == r){
                root.val = n;
                map.put(n,root);
                int n1 = scanner.nextInt();
                if(!map.containsKey(n1)){
                    if(n1 != 0){
                        root.left = new TreeNode1(n1);
                        map.put(n1,root.left);
                    }else{
                        root.left = null;
                    }
                }else {
                    root.left = map.get(n1);
                }
                int n2 = scanner.nextInt();
                if(!map.containsKey(n2)){
                    if(n2 != 0){
                        root.right = new TreeNode1(n2);
                        map.put(n2,root.right);
                    }else{
                        root.right = null;
                    }
                }else{
                    root.right = map.get(n2);
                }
            }else {
                if(!map.containsKey(n)){
                    TreeNode1 roo = new TreeNode1(n);
                    map.put(n,roo);
                    int n1 = scanner.nextInt();
                    if(!map.containsKey(n1)){
                        if(n1 != 0){
                            roo.left = new TreeNode1(n1);
                            map.put(n1,roo.right);
                        }else{
                            roo.left = null;
                        }
                    }else{
                        roo.left = map.get(n1);
                    }
                    int n2 = scanner.nextInt();
                    if(!map.containsKey(n2)){
                        if(n2 != 0){
                            roo.right = new TreeNode1(n2);
                            map.put(n2,roo.right);
                        }else{
                            roo.right = null;
                        }
                    }else {
                        roo.right = map.get(n2);
                    }
                }else{
                    TreeNode1 roo = map.get(n);
                    int n1 = scanner.nextInt();
                    if(!map.containsKey(n1)){
                        if(n1 != 0){
                            roo.left = new TreeNode1(n1);
                            map.put(n1,roo.left);
                        }else{
                            roo.left = null;
                        }
                    }else{
                        roo.left = map.get(n1);
                    }
                    int n2 = scanner.nextInt();
                    if(!map.containsKey(n2)){
                        if(n2 != 0){
                            roo.right = new TreeNode1(n2);
                            map.put(n2,roo.right);
                        }else{
                            roo.right = null;
                        }
                    }else {
                        roo.right = map.get(n2);
                    }
                }
            }
        }
        order order = new order(root);
        order.order1(root);
        System.out.println();
        order.order2(root);
        System.out.println();
        order.order3(root);
    }

}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class order{
    TreeNode1 root;
    public order(TreeNode1 root){
        this.root = root;
    }

    public void order1(TreeNode1 treeNode1){
        if(treeNode1 == null){
            return;
        }
        System.out.print(treeNode1.val + " ");
        order1(treeNode1.left);
        order1(treeNode1.right);
    }
    public void order2(TreeNode1 treeNode1){
        if(treeNode1 == null){
            return;
        }

        order2(treeNode1.left);
        System.out.print(treeNode1.val + " ");
        order2(treeNode1.right);
    }
    public void order3(TreeNode1 treeNode1){
        if(treeNode1 == null){
            return;
        }
        order3(treeNode1.left);
        order3(treeNode1.right);
        System.out.print(treeNode1.val + " ");
    }

}