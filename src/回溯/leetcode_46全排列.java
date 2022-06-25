package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_46全排列 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        List<List<Integer>> permute = solution7.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }
}
class Solution7 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return ans;
    }
    public void dfs(int[] nums){
        if(t.size() == nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],999);
                t.add(nums[i]);
                System.out.println(t.toString());
                dfs(nums);
                t.remove(t.size()-1);
                map.remove(nums[i]);

            }

        }


    }
}