package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode_216组合总和3 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        List<List<Integer>> lists = solution5.combinationSum3(9, 45);
        System.out.println(lists.toString());
    }
}

class Solution5{
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1,0);
        return ans;
    }
    public void dfs(int len,int target,int cur,int sum){
        if(cur > 10 || sum >target){
            return;
        }
        if(t.size() == len && sum == target){
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(cur);
        sum += cur;
        dfs(len, target, cur+1, sum);
        t.remove(t.size()-1);
        dfs(len, target, cur+1, sum-cur);
    }
}
