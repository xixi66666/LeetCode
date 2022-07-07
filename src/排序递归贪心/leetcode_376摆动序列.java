package 排序递归贪心;

/**
 * @author YangChenxi
 *
 */
public class leetcode_376摆动序列 {
}
/*
一个很巧妙的思路：
1.
某个序列被称为「上升摆动序列」，当且仅当该序列是摆动序列，且最后一个元素呈上升趋势。如序列 [1,3,2,4]即为「上升摆动序列」。
某个序列被称为「下降摆动序列」，当且仅当该序列是摆动序列，且最后一个元素呈下降趋势。如序列 [4,2,3,1]即为「下降摆动序列」。
特别地，对于长度为 1 的序列，它既是「上升摆动序列」，也是「下降摆动序列」。
2.
当一个元素比上一个元素大的时候，这时候是上升摆动序列。(但是是由down序列得来的，因为你不能两次都是上升的这样就没有摆动了）
所以这时应该是up的数组长度增加：up = down +1
反之
down = up+1
之后找出最大值即可
3.如果出现连着增大的几个数字怎么办？
这样很简单，如果连着出现: nums[i] > nums[i-1] 就会一直执行up = down+1; 其实up是没有变化的，也就是说up,down长度不变
因为只是将摆动序列的最后一个值不断赋新值罢了，其他值没变的。


 */
class Solution9 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                up = down+1;
            }else if(nums[i] < nums[i-1]){
                down = up +1;
            }
        }
        return nums.length == 0 ? 0 : Math.max(up,down);
    }
}