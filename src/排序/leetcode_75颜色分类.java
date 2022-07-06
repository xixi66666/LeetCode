package 排序;

import java.util.Arrays;
/*
解法1：
遍历一遍数组，找出0,1,2对应的个数，然后再给nums重新赋值，从0到red都为0，red到write都为1，write到blue都为2。
 */
public class leetcode_75颜色分类 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.sortColors(new int[]{2,0,2,1,1,0});
    }
}
class Solution1 {
    public void sortColors(int[] nums) {
        int red = 0,blue = 0,write = 0;
        for(int i : nums){
            if(i == 0){
                red++;
            }else if(i == 1){
                write++;
            }else if(i == 2){
                blue++;
            }
        }
        System.out.println(red+"   " +write+"    " + blue);
        int count = 0;
        while (count < red){
            nums[count] = 0;
            count++;
        }
        while (count < red+write){
            nums[count] = 1;
            count++;
        }
        while (count < red+write+blue){
            nums[count] = 2;
            count++;
        }
        System.out.println(Arrays.toString(nums));
    }
}