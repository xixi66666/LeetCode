/**
 * @author YangChenxi
 */
public class  leetcode_43字符串相乘 {
    public static void main(String[] args) {
        Solution43 solution1 = new Solution43();
        String multiply = solution1.multiply("123", "456");
        System.out.println(multiply);
    }
}
class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for(int i = num1.length()-1;i>=0;i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = num2.length()-1;j>=0;j--){
                int n2 = num2.charAt(j) - '0';
                ansArr[i+j+1] += (n1*n2);
            }
        }
        for(int i = m+n-1;i>0;i--){
            ansArr[i-1] += ansArr[i]/10;
            ansArr[i] = ansArr[i]%10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}