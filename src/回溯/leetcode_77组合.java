package 回溯;

import java.util.ArrayList;
import java.util.List;
//注意，一定要有return
public class leetcode_77组合 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        List<List<Integer>> combine = solution4.combine(4, 2);
        System.out.println(combine.toString());
    }
}

class Solution4 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return ans;
    }
    public void dfs(int max,int len,int cur){
        if(cur > max+1){
            return;
        }
        if(t.size() == len){
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(cur);
        dfs(max, len, cur+1);
        t.remove(t.size()-1);
        dfs(max, len, cur+1);
    }
}
//1. dfs1 add1 dfs2 add2 dfs3 ---> if add 1,2
//2. dfs1 add1 dfs2 add2 remove1 (1,cur = 2)
//3. dfs1 add1 dfs3 add3 dfs4 ---> if add 1,3
//4. dfs1 add1 dfs3 add3 remove1 (1,cur = 3)
//5. dfs1 add1 dfs4 add4 dfs5 ---> return 没有1，4 ans.add的过程