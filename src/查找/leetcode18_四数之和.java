package 查找;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode18_四数之和 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        List<List<Integer>> lists = solution10.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        //System.out.println(lists);

    }
}
class Solution10 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    int count = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        boolean[] booleans = new boolean[nums.length];
        backtrack(nums,target,booleans,0);
        return ans;

    }
    public void backtrack(int[] nums,int target,boolean[] isVisited,int sum){
        if(t.size() == 4 && sum == target) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            t.add(nums[i]);
            backtrack(nums, target, isVisited, sum + nums[i]);
            isVisited[i] = false;
            sum -= nums[i];
            t.remove(t.size()-1);


        }
    }
}