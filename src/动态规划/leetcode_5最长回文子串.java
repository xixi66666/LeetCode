package 动态规划;

/**
 * @program: LeetCode
 * @description: 5
 * @author: 杨晨曦
 * @create: 2023-10-09 18:41
 **/
/*
动态规划：
当一个船是回文串且它的长度大于2 的时候，若它的起始位置为i，终止位置为j 那么[i+1,j-1]这个子串也一定为回文串 并且si = sj
 */
public class leetcode_5最长回文子串 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String s = solution5.longestPalindrome("babad");
        System.out.println(s);
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 0;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //所有长度为1的子串都是回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        //第一个循环是枚举子串的长度，从2开始
        for (int i = 2; i <= s.length(); i++) {
            //第二个循环是枚举子串的左边界的
            for (int left = 0; left < s.length(); left++) {
                int right = i + left - 1;
                if (right >= s.length()) {
                    break;
                }
                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                }
                if (chars[left] == chars[right]) {
                    /*right - i = 0 ------ 就一个字母，肯定是回文 : a
                                = 1 ------ 两个字母，相等的时候是回文又因为 chars[i] == chars[right] 所以肯定是回文:  aa
                                = 2 ------ 三个字母，肯定是回文 : aba
                     */
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                    if (dp[left][right] && right - left + 1 > max) {
                        max = right - left + 1;
                        begin = left;
                    }

                }
            }
        }

        return s.substring(begin, max + begin);
    }
}

/*
中心扩散法：
        int n = s.length();
        if(n<2){
            return s;
            }
        if(n == 2 && s.charAt(0) != s.charAt(1)){
            return s.substring(0,1);
            }
        int start = 0;
        int end = 0;
        for(int i = 0;i<n;i++){
            int len1 = fun(s,i,i);
            int len2 = fun(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start){
            start = i - (len - 1) / 2;
            end = i + len / 2;
            }
        }
        //从beginIndex开始取，到endIndex结束，从0开始数，其中不包括endIndex位置的字符
            return s.substring(start,end+1);
            }

        private int fun(String s,int left,int right){
        while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //在这里 left和right表示的是两个位置，在这两个指针之间的串是回文子串，不包括他俩指向的位置
        //所以长度应该为right-left+1-2
        return right-left-1;

 */

