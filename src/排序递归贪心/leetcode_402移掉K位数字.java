package 排序递归贪心;

/**
 * @author YangChenxi
 */
public class leetcode_402移掉K位数字 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String s = solution8.removeKdigits("1432219", 3);
        System.out.println(s);
    }

}
class Solution8 {
    public String removeKdigits(String num, int k) {
        char s1 = 32677;
        String ans = "";
        for(int i = 0;i<k;i++){
            int index = i;
            for(int j = i;j<num.length();j++){
                if(num.charAt(index) < num.charAt(j)){
                    index = j;
                }
            }
            ans = num.charAt(index) + ans;
            num.replace(num.charAt(index),s1);
        }
        return ans;
    }
}