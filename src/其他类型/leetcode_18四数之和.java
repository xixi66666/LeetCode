package 其他类型;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: 杨晨曦
 * @create: 2022-09-18 11:11
 **/
public class leetcode_18四数之和 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<List<Integer>> lists = solution17.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists.toString());
    }
}
class Solution17 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    boolean[] flag;
    public List<List<Integer>> fourSum(int[] nums, int target){
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,target,0,0);
        return ans;
    }
    public void backtrack(int[] nums,int target,int sum,int cur){
        if(t.size() == 4 && sum == target){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = cur;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1] && !flag[i-1]){
                continue;
            }
            /*
            因为进的是i的循环啊，所以操作的都是i，不是cur，cur就是一个记录i的位置的
             */
            t.add(nums[i]);
            flag[i] = true;
            backtrack(nums, target,sum+nums[i],i+1);
            flag[i] = false;
            t.remove(t.size()-1);
        }
    }
}