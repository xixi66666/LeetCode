package 查找;

public class leetcode33搜索旋转排序数组 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.search(new int[]{1,3},1);
        System.out.println(i);
    }
}
class Solution2 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //这个判断的是如果 0~~mid是有序的话
            if (nums[0] <= nums[mid]) {
                //如果target在这个有序片段之间的话
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //nums[0] > nums[mid]时，说明0~mid不是完全有序的，但是mid~len-1是有序的
                if (nums[mid] < target && target < nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}