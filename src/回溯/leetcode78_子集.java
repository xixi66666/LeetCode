package 回溯;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *当使用list.add(list)的时候，每一次add进去的都是相同对象的引用：t，如果每一次都new一个的话就没有问题了。
 */
public class leetcode78_子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution1 solution1 = new Solution1();
        solution1.subsets(nums);
    }

}
class Solution1 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        System.out.println(ans);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        System.out.println("进行了dfs，cur:" + cur +"   t:" + t.toString() );
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            System.out.println("------------------------------");
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        System.out.println("remove操作之后的cur: " + cur);
        dfs(cur + 1, nums);
    }
}