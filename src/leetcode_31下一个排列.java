import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_31下一个排列 {
    public static void main(String[] args) {
        Solution31 solution6 = new Solution31();
        solution6.nextPermutation(new int[]{1,2,3});
    }
}
class Solution31 {
    List<Integer> list = new ArrayList<>();
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j <len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;

    }
}