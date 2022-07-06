package 查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_611有效三角形的个数 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
    }
}


class Solution3 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    //这里，i代表的是第一条边，j代表的是第二条边，所以使用用二分法找第三条边。
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}