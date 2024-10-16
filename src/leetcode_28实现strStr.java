/**
 * @author YangChenxi
 */
public class leetcode_28实现strStr {
    public static void main(String[] args) {
        Solution28 solution2 = new Solution28();
        int i = solution2.strStr("a", "a");
        System.out.println(i);
    }
}
class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i = 0;i<=haystack.length()-needle.length();i++){
            boolean flag = true;
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i;
                for(int k = 0;k<needle.length();k++){
                    System.out.println(k + " " + j);
                    if(haystack.charAt(j) == needle.charAt(k)){
                        j++;
                    }else{
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
            if(flag == true){
                return i;
            }
        }
        return -1;
    }
}