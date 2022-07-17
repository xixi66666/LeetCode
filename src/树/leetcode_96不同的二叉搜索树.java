package 树;

/**
 * @author YangChenxi
 */
public class leetcode_96不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        solution16.numTrees(3);
    }
}
/*
动态规划：
1.遍历每一个数字i，以i作为树根，这时候 1~i-1为左子树，i+1~n为右子树。接着我们递归的构建右子树和左子树。
2.简单分析，当i为1的时候 只有一种构建方式
3.我们选择数字 i 作为根，则根为 i 的所有二叉搜索树的集合是左子树集合和右子树集合的笛卡尔积,因为每一次的根不同，所以保证了准确性。
 */
class Solution16 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(j-1);
                System.out.print(i-j);
                System.out.println();
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}