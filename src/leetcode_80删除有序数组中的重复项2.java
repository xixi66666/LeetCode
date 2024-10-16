import java.util.HashMap;
import java.util.Map;

/**
 * @author YangChenxi
 */
public class leetcode_80删除有序数组中的重复项2 {
    public static void main(String[] args) {
        Solution80 solution11 = new Solution80();
        int i = solution11.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(i);
    }
}
class Solution80 {
    public int removeDuplicates(int[] nums) {
        /*
         双指针 + map,因为这道题目不让使用新数组，只能原地修改，而且不需要考虑数组中超出新长度后面的元素。
         所以使用双指针，用index表示新数组的下表，遇到符合要求的就nums[index] = nums[i]; 将前面的元素重置，不管后面的。
         */
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            //1.map中没有出现过相关数字
            if(!map.containsKey(nums[i])){
                nums[index] = nums[i];
                index++;
                map.put(nums[i],1);
            }else {
                int number = map.get(nums[i]);
                if(number < 2){
                    nums[index] = nums[i];
                    index++;
                    map.put(nums[i],number+1);
                }
            }
        }
        return index;
    }
}