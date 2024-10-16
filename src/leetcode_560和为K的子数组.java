/**
 * @author YangChenxi
 */
public class leetcode_560和为K的子数组 {
    public static void main(String[] args) {
        Solution560 solution21 = new Solution560();
        int i = solution21.subarraySum(new int[]{1, -1, 0}, 0);
        System.out.println(i);
    }
}
class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}