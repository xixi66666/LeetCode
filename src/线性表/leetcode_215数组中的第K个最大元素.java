package 线性表;

import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class leetcode_215数组中的第K个最大元素 {
}
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}