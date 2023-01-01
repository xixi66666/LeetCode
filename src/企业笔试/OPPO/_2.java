package 企业笔试.OPPO;


/**
 * @author YangChenxi
 */
public class _2 {
}
class Solution {
    public long tourismRoutePlanning (int scenicspot) {
        // write code here
        long[] dp = new long[scenicspot];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i<scenicspot;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[scenicspot-1];
    }
}
