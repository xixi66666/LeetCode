package other.其他类型;

/**
 * @author YangChenxi
 */
public class leetcode_283移动零 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.moveZeroes(new int[]{0,1,0,3,12});

    }
}
class Solution4 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        while(nums[index] != 0){
            index++;
        }
        for(int i = 0;i<len;i++){
            if(nums[i] != 0){
                if(i > index){
                    nums[index] = nums[i];
                    nums[i] = 0;
                    index = i;
                    System.out.println(index);
                }
            }else {
                if(i < index){
                    index = i;
                    System.out.println("----------" + index);
                }
            }
        }
    }
}