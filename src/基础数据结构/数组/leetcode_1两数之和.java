package 基础数据结构.数组;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * @author: 杨晨曦
 * @create: 2023-07-25 20:16
 **/
public class leetcode_1两数之和 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] ints = solution1.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}

/**
 * 下策：
 * 使用map存储对应位置的下标以及对应数值与target的差值  再对数组进行遍历，找到相同的即可
 * 上策：
 * 直接利用HashMap的containsKey方法，只要put的时候将值放到第一个，下表放到第二个即可
 *
*/
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
