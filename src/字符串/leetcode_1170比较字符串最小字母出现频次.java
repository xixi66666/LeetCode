package 字符串;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author YangChenxi
 */
public class leetcode_1170比较字符串最小字母出现频次 {
    public static void main(String[] args) {

    }
}
class Solution3 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] w = new int[words.length];
        int count = 0;
        for(String s : words){
            int index = Integer.MAX_VALUE;
            for(int i = 0;i<s.length();i++){
                index = Math.min(index,s.charAt(i));
            }
            char c = (char) index;
            index = 0;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == c){
                    index++;
                }
            }
            w[count] = index;
            count++;
        }
        count = 0;
        for(String s : queries){
            int index = Integer.MAX_VALUE;
            for(int i = 0;i<s.length();i++){
                index = Math.min(index,s.charAt(i));
            }
            char c = (char) index;
            index = 0;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == c){
                    index++;
                }
            }
            for(int i : w){
                if (index < i){
                    ans[count]++;
                }
            }
            count++;
        }
        return ans;
    }
}