package 排序递归贪心;

import java.util.ArrayList;
import java.util.List;

public class leetcode_315计算右侧小于当前元素的个数 {
    public static void main(String[] args) {

    }
}
/*
时间复杂度太高了，超时了。
 */
class Solution3 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length-1;i++){
            int count = 0;
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            ans.add(count);
        }
        ans.add(0);
        return ans;
    }
}