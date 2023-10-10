package 字符串;

/**
 * @program: LeetCode
 * @description: 125
 * @author: 杨晨曦
 * @create: 2023-02-01 14:21
 *
 * 思路：
 * 1，将字符串全部变成小写
 * 2.去掉不合法的字符： 用一个新数组存储，对于字符串的多次操作尽量使用StringBuilder提高效率
 * 3.回文的比较方法：中心扩散法
 **/
public class leetcode_125验证回文串 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
class Solution6 {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        //1.先全部变成小写
        s = s.toLowerCase();
        //2.去掉所有的不合法字符,注意使用api Character.isLetterOrDigit();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stringBuilder.append(c);
            }
        }
        if(stringBuilder.toString().equals("")){
            return true;
        }
        return isOrNot(stringBuilder.toString());
    }

    public boolean isOrNot(String s){
        int len = s.length();
        int start;
        int end;
        if(len % 2 == 0){
            start = len/2-1;
            end = len/2;
        }else {
            start = len/2-1;
            end = len/2+1;
        }
        while(start >= 0 && end < len){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start--;
                end++;
            }
        }
        return true;
    }
}
