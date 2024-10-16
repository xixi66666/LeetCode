import java.util.ArrayList;
import java.util.List;

public class leetcode_46全排列 {
    public static void main(String[] args) {
        Solution46 solution7 = new Solution46();
        List<List<Integer>> permute = solution7.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }
}
class Solution46 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used);
        return ans;
    }
    public void backtrack(int[] nums,boolean[] isVisited){
        if(t.size() == nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            t.add(nums[i]);
            backtrack(nums, isVisited);
            isVisited[i] = false;
            t.remove(t.size()-1);
        }


    }
}