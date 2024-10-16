public class leetcode_34在排序数组中查找元素的第一个和最后一个位置 {

}


class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start+end)/2;
        int[] res = new int[2];
        if(end == 0){
            return new int[]{-1, -1};
        }
        while(start <= end){
            if(target == nums[mid]){
                int i = mid,j = mid;
                while(nums[i+1] == target){
                    i++;
                }
                while(nums[j-1] == target){
                    j--;
                }
                res[0] = j;
                res[1] = i;
                return res;
            }else if(target < nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}