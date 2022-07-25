package Hot100;

/**
 * @author YangChenxi
 */
public class leetcode_581最短无序连续子数组 {
}
class Solution20 {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end && nums[start+1] >= nums[start]){
            start++;
        }
        while (end > start && nums[end-1] <= nums[end]){
            end--;
        }
        if(start >= end){
            return 0;
        }
        int min = 0,max = 0;
        for(int i = start;i<end;i++){
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        System.out.println(min);
        System.out.println(max);
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > start){
                start= i;
                break;
            }
        }
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] < end){
                end = i;
                break;
            }
        }
        return end-start+1;

    }
}