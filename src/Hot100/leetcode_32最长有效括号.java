package Hot100;

/**
 * @author YangChenxi
 * 感觉和括号生成很像啊，可以拿那道题的思路看一下
 * 注意，要找的是连续的括号
 */
public class leetcode_32最长有效括号 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.longestValidParentheses(")()())");
        System.out.println(i);
    }
}
/*
动态规划的思路：
1.一个有效的子串肯定是以右括号)为结束的
当s[i] = ) 时，当其前面一个为左括号的时候构成了一个有效括号。表示为dp[i] = dp[i-2]+2
2.如果s[i] = ) 且 s[i-1] = )
那么第i个位置的右括号 对应的左括号肯定在第i-1个位置的右括号对应的左括号的前面（可能有点绕，多看几遍
如果第i-1个位置的括号与前面的左括号构成了()，那么第i个位置对应的左括号要追到 s[i-1-dp[i-1]],如果这个位置的字符是左括号，那么也成立。
 */

class Solution8 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //i - dp[i-1] > 0 这一个条件，我的理解是当出现)的时候，如果前面全部是连续合法的括号组合，那么这个右括号就没有对应的左括号了，所以就不合法。
                //只有前面有多余的( 的时候才能匹配
                else if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    //(i - dp[i - 1]) >= 2只有大于2的时候
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}