package 基础数据结构.字符串;

import java.util.Objects;

/**
 * @author YangChenxi
 * 思路：
 *  1.以数组的第一个字符串为基，循环匹配往后的每一个字符串
 *  2.匹配的方式很简单，就是逐个匹配后记录匹配了多少个字母。
 *  3.匹配失败的情况：一个字符串已经全部被匹配（匹配完了），或者直接就字母不一样，不匹配。这时候就可以更新ans了，为 ans.substring(0,count);
 *  4.还得练啊
 */
public class leetcode_14最长公共前缀 {
    public static void main(String[] args) {
        Solution14 solution7 = new Solution14();
        String s = solution7.longestCommonPrefix(new String[]{"ab","a"});
        System.out.println(s);
    }
}
class Solution14 {
    public String longestCommonPrefix1(String[] strs) {
        String ans = strs[0];

        for(int i = 1;i<strs.length;i++){
            int count = 0;
            if(Objects.equals(strs[i], "")){
                return "";
            }
            while (count < strs[i].length() && count < ans.length()){
                if(ans.charAt(count) == strs[i].charAt(count)){
                    count++;
                }else {
                    ans = ans.substring(0,count);
                }
                if(count == ans.length() || count == strs[i].length()){
                    ans = ans.substring(0,count);
                }
            }

        }
        return ans;
    }

































    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i = 1;i<strs.length;i++){
            int count = 0;
            if(strs[i].equals("")){
                return "";
            }
            while(count < ans.length() && count < strs[i].length()){
                if(ans.charAt(count) == strs[i].charAt(count)){
                    count++;
                }else{
                    ans = ans.substring(0,count);
                }
                if(count == ans.length() || count == strs[i].length()){
                    ans = ans.substring(0,count);
                }
            }
        }
        return ans;
    }
}