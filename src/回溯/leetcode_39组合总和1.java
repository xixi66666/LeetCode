package 回溯;

import java.util.ArrayList;
import java.util.List;
//对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
public class leetcode_39组合总和1 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<List<Integer>> lists = solution6.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists.toString());
    }
}
class Solution6 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }
    // 选或者不选index的值,这一步是需要脑子的剪枝操作
    public void dfs(int[] nums,int target,int index){
        if(index == nums.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(t));
            return;
        }
        //跳过当前数字
        dfs(nums, target, index+1);
        //选择当前数字
        if(target - nums[index] >= 0){
            t.add(nums[index]);
            //这一步保证了可以多次选择自己
            dfs(nums, target-nums[index], index);
            t.remove(t.size()-1);
        }
    }

}