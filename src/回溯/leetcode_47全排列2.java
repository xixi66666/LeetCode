package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_47全排列2 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        List<List<Integer>> permute = solution8.permute(new int[]{1, 3, 2});
        System.out.println(permute.toString());
    }
}

class Solution8 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> t = new ArrayList<>();
    boolean[] flag;
    public List<List<Integer>> permute(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0);
        return ans;
    }
    /*
    for循环保证了从数组中从前往后一个一个取值，再用if判断条件。
    所以nums[i - 1]一定比nums[i]先被取值和判断。
    如果nums[i - 1]被取值了，那vis[i - 1]会被置1，只有当递归再回退到这一层时再将它置0。
    每递归一层都是在寻找数组对应于递归深度位置的值，每一层里用for循环来寻找。
    所以当vis[i - 1] == 1时，说明nums[i - 1]和nums[i]分别属于两层递归中，
    也就是我们要用这两个数分别放在数组的两个位置，这时不需要去重。
    但是当vis[i - 1] == 0时，说明nums[i - 1]和nums[i]属于同一层递归中（只是for循环进入下一层循环），
    也就是我们要用这两个数放在数组中的同一个位置上，这就是我们要去重的情况。
     */
    public void backtrack(int[] nums,int cur){
        if(cur== nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            //continue:跳过当前循环继续下一个循环。
            if(flag[i] || i > 0 && nums[i] == nums[i-1] && !flag[i-1]){
                continue;
            }
            t.add(nums[i]);
            flag[i] = true;
            backtrack(nums,cur+1);
            flag[i] = false;
            t.remove(cur);
            }
        }
}