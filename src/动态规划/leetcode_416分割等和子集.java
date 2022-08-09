package 动态规划;

/**
 * @author YangChenxi
 */
public class leetcode_416分割等和子集 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.canPartition(new int[]{1,5,11,5});
    }
}
class Solution2 {
    int ans = 0;
    boolean b  = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        backtrack(nums,0,sum/2);
        return b;
    }
    public void backtrack(int[] nums, int index, int target){
        if(ans == target){
            b = true;
        }
        if(index >= nums.length){
            return ;
        }
        if(ans > target){
            return ;
        }
        System.out.println(ans);
        ans += nums[index];
        backtrack(nums,index+1,target);
        ans -= nums[index];
        backtrack(nums,index+1,target);
    }
}