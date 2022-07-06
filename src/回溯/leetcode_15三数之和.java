package 回溯;

import java.util.*;

/**
 * @author YangChenxi
 * 思路：双指针法
 */
public class leetcode_15三数之和 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        List<List<Integer>> lists = solution9.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
class Solution9 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int number = nums.length;
        Arrays.sort(nums);
        for(int a = 0;a<number;a++){
            if(a > 0 && nums[a] == nums[a-1]){
                continue;
            }
            int target = -nums[a];
            int c = number-1;
            for(int b = a+1;b<number;b++){
                if(b > a+1 && nums[b] == nums[b-1]){
                    continue;
                }
                while(b < c && nums[b] + nums[c] > target){
                    c--;
                }
                if(b == c){
                    break;
                }
                if(nums[b] + nums[c] == target){
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[a]);
                    t.add(nums[b]);
                    t.add(nums[c]);
                    ans.add(t);
                }

            }
        }
        return ans;
    }
}