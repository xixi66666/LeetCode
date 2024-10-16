public class leetcode_137_只出现一次的数2 {
    public static void main(String[] args) {
        System.out.println(new Solution137().singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
class Solution137 {
    public int singleNumber(int[] nums) {
        int index = 0;
        for(int num : nums){
            index ^= num;
            if(index == 0){
                index ^= num;
            }
            System.out.println(index);
        }
        return index;
    }
}