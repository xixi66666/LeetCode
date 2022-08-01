package Hot100;
/**
 * @author YangChenxi
 */
public class leetcode_152乘积最大子数组 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int i = solution22.maxProduct(new int[]{2,3,-2,4});
    }
}
/*
动态规划
 */
class Solution22 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = 0;i<len;i++){
            dp[i] = nums[i];
            int sum = nums[i];
            for(int j = i+1;j<len;j++){
                sum *= nums[j];
                dp[i] = Math.max(dp[i],sum);
            }
            System.out.println(dp[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}