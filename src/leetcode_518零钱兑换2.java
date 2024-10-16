import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class leetcode_518零钱兑换2 {
    public static void main(String[] args) {
        Solution518 solution1 = new Solution518();
        int change = solution1.change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin;i<=amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}