package 查找;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_268丢失的数字 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int i = solution7.missingNumber(new int[]{3, 0, 1});
        System.out.println(i);

    }
}
class Solution7 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int missing = -1;
        Set<Integer> map = new HashSet<>();
        for(int i = 0;i<len;i++){
            map.add(nums[i]);
        }
        for(int i = 0;i <= len;i++){
            if(!map.contains(i)){
                missing = i;
                break;
            }
        }
        return missing;
    }
}