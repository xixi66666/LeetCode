package 其他类型;

/**
 * @author YangChenxi
 */
public class leetcode_283移动零 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.moveZeroes(new int[]{0,1,0,3,12});
    }
}
/*
思路：记录0 的个数，把所有不是零的放在前面就行
 */
class Solution4 {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
}