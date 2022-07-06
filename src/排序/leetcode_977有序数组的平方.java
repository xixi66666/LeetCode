package 排序;

import java.util.Arrays;

public class leetcode_977有序数组的平方 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] ints = solution4.sortedSquares(new int[]{3, 5, 2, 1, 4, 6, 7, 8, 0, 9});
        System.out.println(Arrays.toString(ints));

    }
}
class Solution4 {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0;i< nums.length;i++){
            int number = nums[i] * nums[i];
            nums[i] = number;
        }
        /*
        冒泡法
         */
        for(int i = 0;i<nums.length-1;i++){
            for(int j = 0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }

}