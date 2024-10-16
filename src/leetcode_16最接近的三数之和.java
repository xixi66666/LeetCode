import java.util.*;

/**
 * @author YangChenxi
 * 排序+双指针
 */
public class leetcode_16最接近的三数之和 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5},-2));
    }
}
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        for(int a = 0;a < len;a++){
            if(a > 0 && nums[a] == nums[a-1]){
                continue;
            }
            int b = a+1;
            int c = len-1;
            /*
            这一步为什么必须要while不能用for循环呢，因为比如需要b不变然后让c向前移动，这时候执行c--就跳出循环了，直接到b的循环里进行b++了，就会产生错误。
             */
            while (b<c){
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