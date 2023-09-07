package 线性表;

import java.util.*;

public class leetcode_239最大滑动窗口 {
    public static void main(String[] args) {
        Solution239 maxWindow = new Solution239();
        //int[] num = maxWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3);
        int[] num = maxWindow.maxSlidingWindow(new int[]{1, -1},1);
        System.out.println(Arrays.toString(num));

    }
}
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] dp = new int[nums.length-k+1];
        for(int i = 0;i<=nums.length-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j = i;j<k+i;j++){
                max = Math.max(max,nums[j]);
            }
            dp[i] = max;
        }
        return dp;
    }
}