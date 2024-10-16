/**
 * @program: LeetCode
 * @description: null
 * @author: 杨晨曦
 * @create: 2022-09-06 13:35
 **/
public class leetcode_45跳跃游戏 {

}
class Solution45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
            System.out.println(steps);
        }
        return steps;
    }
}