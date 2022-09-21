package other;

import java.util.Arrays;

/**
 * @author YangChenxi
 * 双指针法，一个指针p0代表交换0元素的位置，p1代表交换1元素的位置
 * 注意当p0<p1 的时候会出现将一个1换到第i个位置的情况，这时候在进行一次i和p1位置的交换即可。
 */
public class leetcode75_颜色分类 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] i = new int[]{2,0,2,1,1,0};
        solution12.sortColors(i);
        System.out.println(Arrays.toString(i));
    }

}
class Solution12 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0<p1){
                    int t = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = t;
                }
                p0++;
                p1++;

            }
        }
    }
}