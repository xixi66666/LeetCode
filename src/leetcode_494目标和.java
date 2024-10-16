/**
 * @author YangChenxi
 */
public class leetcode_494目标和 {
}
class Solution494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,target,0);
        return count;
    }
    public void backtrack(int[] nums,int cur,int target,int sum){
        if(cur == nums.length-1 && sum == target){
            count++;
        }
        if(cur > nums.length){
            return;
        }else {
            backtrack(nums, cur+1, target, sum+nums[cur]);
            backtrack(nums, cur+1, target, sum-nums[cur]);
        }

    }
}