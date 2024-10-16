/**
 * @author YangChenxi
 */
public class leetcode_38外观数列 {
    public static void main(String[] args) {
        Solution38 solution2 = new Solution38();
        String s = solution2.countAndSay(5);
        System.out.println(s);
    }
}
class Solution38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}