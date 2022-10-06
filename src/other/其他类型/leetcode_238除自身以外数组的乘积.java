package other.其他类型;

import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class leetcode_238除自身以外数组的乘积 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] ints = solution10.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

}
class Solution10 {
    public int[] productExceptSelf(int[] nums) {
        /*
        思路：
        1.不让使用除法
        2.那就考虑每一个点他的除自身以外数组的乘积，就是他左侧的所有数的乘积乘上他右侧的所有数的乘积
        3.构建两个数组，表示第i个数的左/右侧乘积就行了
         */
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for(int i = 1;i<nums.length;i++){
            L[i] =  L[i-1] * nums[i-1];
        }
        R[nums.length-1] = 1;
        for(int i = nums.length-2;i>= 0;i--){
            R[i] = R[i+1] * nums[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}