package 排序;

import java.util.Arrays;

public class leetcode_455分发饼干 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int contentChildren = solution5.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
        System.out.println(contentChildren);
    }
}
class Solution5 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length-1;
        int slen = s.length-1;
        int count = 0;
        while (slen >= 0){
            if(glen < 0){
                break;
            }
            if(s[slen] >= g[glen]){
                count++;
                slen--;
                glen--;
            }
            else{
                glen--;
            }
        }
        return count;
    }
}