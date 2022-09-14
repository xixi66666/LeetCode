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
        StringBuilder ans = new StringBuilder();
        int len = num.length();
        while(k>0){
            for(int i = 0;i<len;i++){
                if(ans.length() == 0){
                    ans.append(num.charAt(i));
                }else if (num.charAt(i) < num.charAt(i-1)){
                    System.out.println("before = " + ans);
                    ans = ans.replace(ans.length()-1,ans.length(), String.valueOf(num.charAt(i)));
                    System.out.println("after = " + ans);
                    k--;
                }else{
                    ans.append(num.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}