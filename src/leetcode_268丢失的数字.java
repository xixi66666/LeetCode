import java.util.HashSet;
import java.util.Set;

public class leetcode_268丢失的数字 {
    public static void main(String[] args) {
        Solution268 solution7 = new Solution268();
        int i = solution7.missingNumber(new int[]{3, 0, 1});
        System.out.println(i);

    }
}
class Solution268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int missing = -1;
        Set<Integer> map = new HashSet<>();
        for(int i = 0;i<len;i++){
            map.add(nums[i]);
        }
        for(int i = 0;i <= len;i++){
            if(!map.contains(i)){
                missing = i;
                break;
            }
        }
        return missing;
    }
}