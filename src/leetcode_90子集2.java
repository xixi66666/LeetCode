import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 90
 * @author: 杨晨曦
 * @create: 2022-10-19 22:36
 **/
public class leetcode_90子集2 {
    public static void main(String[] args) {
        Solution90 solution10 = new Solution90();
        List<List<Integer>> lists = solution10.subsetsWithDup(new int[]{1, 2, 3});
        System.out.println(lists.toString());
    }

}
class Solution90 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<Integer>();
    boolean[] flag ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0);
        return ans;

    }
    public void backtrack(int[] nums,int cur){
        System.out.println(t.toString() + "cur : "  + cur);
        ans.add(new ArrayList<>(t));
        for(int i = cur;i<nums.length;i++){
            //去重的条件
            if(flag[i] || i > 0 && nums[i] == nums[i-1] && !flag[i-1]){
                continue;
            }
            t.add(nums[i]);
            flag[i] = true;
            backtrack(nums, cur+1);
            /*这里为什么是i + 1 而不是cur + 1呢，因为前面我们有t.add(nums[i]);又因为我们经过排序之后是有序的，所以我们后面挑的数字一定是i之后的数字
            而cur与i并不是完全同步的，可能i = 3的时候 cur = 1会造成错误
             */
            flag[i] = false;
            t.remove(t.size()-1);

        }
    }

}