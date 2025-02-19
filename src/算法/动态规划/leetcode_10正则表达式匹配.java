package 算法.动态规划;

/**
 * @program: LeetCode
 * @description: 10
 * @author: 杨晨曦
 * @create: 2022-11-03 09:23
 **/
public class leetcode_10正则表达式匹配 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        boolean flag = solution10.isMatch("aab", "c*a*b");
        System.out.println(flag);

    }

}

/**
 * 这道题最难的地方在于 出现 * 时的情况分析以及状态转移方程的编写，使用动态规划
 * 动态规划：
 * 1.数据dp[i][j] 代表 s的前 i 个字符 和 p的前 j 个字符是否匹配
 * 注意 这里说的是前i个字符，即dp[i] 带代表的是s[i-1]
 * 2. 当 p 的第 j - 1 个字符是一个字母而不是符号的时候
 * 2.1 s[i-1] = p[j-1]
 * dp[i][j] =  dp[i-1][j-1] && s[i-1] = p[j-1]
 * 2.2 s[i-1] != p[j-1]
 * dp[i][j] = false
 * 3. 当 p 的第 j-1 个字符是 * 的时候
 * 有一个重要概念 ： * 匹配0次的时候 例如 abc* 匹配0次时为（ab）  匹配1次的时候 （abc）
 * ！！！ 但是有个问题是 * 可以匹配多次，那么就要写很多次的状态转移方程
 * 例如：
 * 匹配0次： dp[i][j] = dp[i][j-2]
 * 匹配1次： dp[i][j] = dp[i-1][j-2] && s[i-1] = p[j-2]
 * 匹配2次： dp[i][j] = dp[i-2][j-2] && s[i-2] = s[i-1] = p[j-2]
 * 难以理解的点是：当匹配一次或者多次的时候 状态转移方程就得往前推了，例如 abcc  和  abc* 当匹配两次的时候说明需要
 * dp[i-2][j-2] = true 并且s的后两个值 与 p[j-2]的值相等
 * 3.1
 * 如果我们通过这种方法进行转移，那么我们就需要枚举这个组合到底，非常繁琐
 * 所以我理解使用了一种类似于递归的方式：
 * 字母 + 星号 的规则实际上只有两种情况：
 * 1.字符不匹配的时候，直接扔掉这个组合，即扔掉字母 + 星号 这两个字符
 * dp[i][j] = dp[i][j-2]     s[i-1] != p[j-1]
 * 2.匹配s末尾的字符，把这个字符扔掉，还可以匹配。 例如 abcc 和 abc* 扔掉一个c变成了 abc 和abc*还能继续匹配
 * dp[i-1][j] || dp[i][j-2]  s[i-1] = p[j-1]
 * <p>
 * 3.2
 * 只要出现 . 就可以匹配任意的字母
 * 3.3
 * dp[0][0] 为true
 */
class Solution10 {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean dp[][] = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j-1) != '*') {
                    if (i == 0) {
                        dp[i][j] = false;
                    } else {
                        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                } else {
                    dp[i][j] = dp[i][j - 2];
                    /*
                    这里我一直错的地方是我理解i=0的时候我给dp[i][j] 都赋值为 false了。其实不对
                    因为i=0时的dp[i][j] 的决定因素是 dp[i][j - 2] ： 意思是当p[j-1] 为 * 的时候 我选择匹配0次 以 s = aa p = a*举例，那么dp[0][2] = dp[0][0] = true

                    这里为什么要i != 0 呢？因为像上面说的 匹配s末尾的字符，把这个字符扔掉，还可以匹配。 如果是0的话没办法扔掉这个字符会空指针异常。而为0且p[j-1] 为 *的情况我们已经讨论过。所以不需要0
                     */
                    if (i != 0) {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j] || dp[i - 1][j] ;
                        }
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }
}