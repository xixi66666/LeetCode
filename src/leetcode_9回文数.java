/**
 * @Author: [xixixiaozi]
 * @Description:
 * @Date: 2025/2/11 19:11
 */
public class leetcode_9回文数 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean palindrome = solution9.isPalindrome(10);
        System.out.println(palindrome);
    }
}
/**
 * @Author xixixiaozi
 * @Description: 简单题，稍微用一下整数反转的思路就行了
 * @Date 19:14 2025/2/11
 * @Param
 * @return
 **/
class Solution9 {
    public boolean isPalindrome(int x) {
        int res = 0;
        int number = x;
        if (x < 0) {
            return false;
        } else {
            while (number > 0) {
                int i = number % 10;
                number = number / 10;
                res = res * 10 + i;
            }

        }
        if (res == x) {
            return true;
        }else {
            return false;
        }
    }
}