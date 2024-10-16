import java.util.*;

public class leetcode_40组合总和2 {
    public static void main(String[] args) {
        Solution40 solution2 = new Solution40();
        int[] num = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = solution2.combinationSum2(num, 8);
        System.out.println(lists.toString());

    }
}
/*
思路正确，但是超时。
 */
//class Solution2 {
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    List<Integer> t = new ArrayList<>();
//    Set<List<Integer>> set = new HashSet<>();
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        dfs(candidates,target,0);
//        return ans;
//    }
//    public void dfs(int[] nums,int target,int cur){
//        if(target == 0){
//            List<Integer> before = new ArrayList<>(t);
//            /*
//            这里使用了sort，所以会打乱t的本来顺序，这时候删除的时候就会出现错误。
//             */
//            Collections.sort(t);
//            if(!set.contains(t)){
//                ans.add(new ArrayList<>(t));
//                set.add(t);
//            }
//            t = before;
//            return;
//        }
//        if(target < 0){
//            return;
//        }
//        if(cur == nums.length){
//            return;
//        }
//        t.add(nums[cur]);
//        dfs(nums, target-nums[cur], cur+1);
//        t.remove(t.size()-1);
//        dfs(nums, target, cur+1);
//    }
//}
class Solution40 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return ans;
    }
    private void backtrack(int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            if(i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            int rs = candidates[i] + sum;
            if(rs <= target) {
                t.add(candidates[i]);
                System.out.println(t);
                backtrack(candidates,target,rs,i+1);
                t.remove(t.size()-1);
            } else {
                break;
            }
        }
    }
}