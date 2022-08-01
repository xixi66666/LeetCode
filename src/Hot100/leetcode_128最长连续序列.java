package Hot100;

import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class leetcode_128最长连续序列 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int i = solution26.longestConsecutive(new int[]{1, 2, 0, 1});
        System.out.println(i);
    }
}
class Solution26 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        if(nums.length == 0){
            return 0;
        }
        Arrays.fill(dp,1);
        int ans = 1;
        int count = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == count){
                dp[i] = dp[i-1];
                continue;
            }
            if(nums[i] == count+1){
                //System.out.println(count);
                dp[i] = dp[i-1]+1;
                count = nums[i];
            }else{
                count = nums[i];

            }
        }
        for(int i = 0;i<dp.length;i++){
            System.out.println("dp: " + dp[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}