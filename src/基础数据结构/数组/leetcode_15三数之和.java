package 基础数据结构.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15三数之和 {
    public static void main(String[] args) {
        Solution15_1 solution4 = new Solution15_1();
        List<List<Integer>> lists = solution4.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // -4 -1 -1 0 1 2
        System.out.println(lists.toString());
    }
}

/*
写出了递归的解法，但是会超时
 */
class Solution15_1 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int cur) {
            if (t.size() == 3 && sum == 0) {
                if(!ans.contains(t)){
                    ans.add(new ArrayList<>(t));
                }

                return;
            }
            if (t.size() > 3 || cur >= nums.length) {
                return;
            }
            t.add(nums[cur]);
            sum += nums[cur];
            backtrack(nums, cur + 1);
            t.remove(t.size() - 1);
            sum -= nums[cur];
            backtrack(nums, cur + 1);
        }
    }


class Solution15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧   这里nums[second] + nums[third]如果小于的话就直接进入到后续的判断了
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}