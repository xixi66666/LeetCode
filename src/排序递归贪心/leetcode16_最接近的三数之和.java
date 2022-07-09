package 排序递归贪心;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode16_最接近的三数之和 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.threeSumClosest(new int[]{1,1,1,0},-100));
    }
}
class Solution10 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for(int a = 0;a < len;a++){
            if(a > 0 && nums[a] == nums[a-1]){
                continue;
            }
            int c = len-1;
            for(int b = a+1;b<len;b++){
                if(b >= c){
                    break;
                }
                int sum = nums[a] + nums[b] + nums[c];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }
                if(sum > target){
                    int c0 = c-1;
                    //这一步是防止c和c0对应的值相等，即找到下一个不相等的元素
                    while(c0 > b && nums[c] == nums[c0]){
                        c0--;
                    }
                    c = c0;
                }else{
                    int b0 = b+1;
                    while (b0 < c && nums[b] == nums[b0]){
                        b0++;
                    }
                    b = b0;
                }
            }
        }
        return ans;
    }
}