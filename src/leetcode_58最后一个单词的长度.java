/**
 * @author YangChenxi
 */
public class leetcode_58最后一个单词的长度 {
    public static void main(String[] args) {

    }

}
class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] ans = s.split(" ");
        String a = ans[ans.length-1];
        return a.length();
    }
}