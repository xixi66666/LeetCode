package 线性表;

import java.util.*;

public class leetcode3无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution3 rain = new Solution3();
        System.out.println(rain.LengthOfRain("pwwkew"));
    }
}

class Solution3{
    public int LengthOfRain(String s){
        Set<Character> set = new HashSet<>();
        int end = -1,ans = 0;
        for(int i = 0;i<s.length();i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while (end+1<s.length() && !set.contains(s.charAt(end+1))){
                set.add(s.charAt(end+1));
                end++;
            }
            System.out.println(end);
            ans = Math.max(ans,end-i+1);
        }
        return ans;
    }
}