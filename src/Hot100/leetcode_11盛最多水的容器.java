package Hot100;

import java.util.Arrays;

public class leetcode_11盛最多水的容器 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] dp = new int[]{1,8,6,2,5,4,8,3,7};
        int i = solution2.maxArea(dp);
        System.out.println(i);
    }
}

class Solution2 {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int sum = 0;
        while(start < end){
            sum = Math.max(Math.min(height[start],height[end]) * (end-start),sum);
            //System.out.println(sum);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return sum;
    }
}