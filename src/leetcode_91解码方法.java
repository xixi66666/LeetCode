/**
 * @author YangChenxi
 */
public class leetcode_91解码方法 {
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int i = solution91.numDecodings("11106");
        System.out.println(i);
    }
}
/*
动态规划，dp[i] 为第i个数字时可以转换的方式有几种。有以下几种情况需要考虑：
1. ‘0’ 字符的时候说明不能单独成为一个解码方法
2. 上一个字符是 1/2 的时候就有更多的方式了
 */
class Solution91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[0] = 1;
        for(int i = 1;i<=s.length();i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if(i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0' <= 26)){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}