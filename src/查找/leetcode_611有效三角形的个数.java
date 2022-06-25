package 查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_611有效三角形的个数 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        //int i = solution3.triangleNumber(new int[]{1, 2, 3, 4,5,6});
        System.out.println(1/2);



    }
}


class Solution3 {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        int left,right;
        int sum = 0;
        for(int i = 0;i<len-2;i++){
            left = i+1;
            right = i+2;
            while (right <= len){
                if(nums[i] == 0 || nums[left] == 0 || nums[right] == 0){
                    break;
                }
                if(nums[i] + nums[left] > nums[right] && right <len){
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    sum++;
                    right++;
                }else if (nums[i] + nums[left] <= nums[right] && right <len){
                    right++;
                }else if (right == len && right-left>=1){
                    left++;
                    right = left+1;
                }else{
                    break;
                }
            }
        }
        return sum;
    }
}