package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode_40组合总和2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] num = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = solution2.combinationSum2(num, 8);
        System.out.println(lists.toString());

    }
}

class Solution2 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] nums,int target,int cur){
        if(cur == nums.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[cur]);
        dfs(nums, target-nums[cur], cur+1);
        t.remove(t.size()-1);
        dfs(nums, target, cur+1);
    }
}