package Hot100;

import java.util.Collections;

/**
 * @author YangChenxi
 */
public class leetcode_76最小覆盖子串 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        String s = solution12.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
class Solution12 {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int sum = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0;i<len1-len2;i++){
            int count = 0;
            for(int j = i;j<len1;j++){
                if(count == t.length()){
                    if(sum > j-i){
                        sum = j-i;
                        ans = s.substring(i,j);
                        System.out.println(ans);
                    }
                    break;
                }
                if(s.charAt(j) == t.charAt(count)){
                    count++;
                }
            }
        }
        return ans;
    }
}