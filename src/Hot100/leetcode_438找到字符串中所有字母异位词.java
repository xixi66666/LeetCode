package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_438找到字符串中所有字母异位词 {
}
class Solution27{
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if(sLen < pLen){
            return ans;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0;i<pLen;i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        //注意，这里要使用Arrays.equals
        if(Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        for(int i = 0;i<sLen-pLen;i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i+pLen) - 'a']++;
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}