package 基础数据结构.字符串;

/**
 * @program: LeetCode
 * @description:
 * @author: 杨晨曦
 * @create: 2023-11-28 22:55
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数
 **/
public class leetcode_8字符串转换成整数 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.myAtoi("2147483646");
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(i);
    }

}
class Solution8 {
    public int myAtoi(String s) {
        s = s.trim();
        int sum = 0;
        boolean flag = true;
        if(s.isEmpty()){
            return 0;
        }
        if(s.charAt(0) == '-'){
            flag = false;
        }
        for(int i = 0;i<s.length();i++){
            int number = (int)s.charAt(i) - 48;
            if(i == 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')){
                continue;
            }
            if(number < 0 || number > 9){
                return flag?sum:-sum;
            }
            if(sum > Integer.MAX_VALUE / 10 && flag){
                return Integer.MAX_VALUE;
            }
            if(sum > Integer.MAX_VALUE / 10 && !flag){
                return Integer.MIN_VALUE;
            }
            if(sum == Integer.MAX_VALUE / 10 && number >= 7 && flag){
                return Integer.MAX_VALUE;
            }
            if(sum == Integer.MAX_VALUE / 10 && number >= 8 && !flag){
                return Integer.MIN_VALUE;
            }

            sum = sum * 10 + number;

        }
        return flag?sum:-sum;
    }
}