package 其他类型;

/**
 * @author YangChenxi
 */
public class leetcode_1049最后一块石头的重量2 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        solution13.lastStoneWeightII(new int[1]);
    }



}
class Solution13{
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int n1 : stones){
            sum += n1;
        }
        int n = stones.length;
        int m = sum/2;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        /*
        前i个能不能凑成j的重量
         */
        for(int i = 0;i<=n;i++){
            for(int j = 0;j <= m;j++){
                if(j < stones[i]){
                    dp[i+1][j] = dp[i][j];
                }
                else{
                    dp[i+1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }
        for (int j = m;; --j) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }
}