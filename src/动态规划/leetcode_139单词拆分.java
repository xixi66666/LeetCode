package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 139
 * @author: 杨晨曦
 * @create: 2022-10-27 22:06
 **/
public class leetcode_139单词拆分 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        boolean leetcode = solution15.wordBreak("aaaaaaa", list);
        System.out.println(leetcode);

    }
}
/*
使用字符串的遍历+匹配会出现一个问题 aaaaaaa 和 aaa aaaa的问题，会匹配不上，因为会先匹配aaa，所以使用动态规划会好一点
 */

class Solution15 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}