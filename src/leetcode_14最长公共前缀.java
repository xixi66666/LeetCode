/**
 * @author YangChenxi
 */
public class leetcode_14最长公共前缀 {
    public static void main(String[] args) {
        Solution14 solution7 = new Solution14();
        String s = solution7.longestCommonPrefix(new String[]{"ab","a"});
        System.out.println(s);
    }
}
class Solution14 {
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