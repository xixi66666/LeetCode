package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: 杨晨曦
 * @create: 2023-07-30 21:54
 **/
public class leetcode_3无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int number = solution3.lengthOfLongestSubstring("pwwkew");
        System.out.println(number);
    }

}
/*
初步想法：使用滑动窗口，利用hashmap进行存储
因为是滑动窗口，所以使用left作为左边界, i作为右边界，max代表着滑动窗口的最大值
这里的难点就是left的位置判断问题：
当字符串为pwwkew的时候，如果只是 left = map.get(s.charAt(i)); 这样确定位置的话 就会出现两个w w分别为位置 1 2，left应该出现在2位置，但是却出现在了1
所以left的确认应该是：left = Math.max(left,map.get(s.charAt(i))+1);
为什么是这样的呢，而不是 left = s.charAt(i) ?  牵扯到当前字符包不包含在当前最长有效子段中（非常重要！）（非常重要！）（非常重要！）
带入 s = abba
我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
应该不变，left始终为2
为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).


远古代码：
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = -1,ans = 0;
        for(int i = 0;i<s.length();i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while (end+1<s.length() && !set.contains(s.charAt(end+1))){
                set.add(s.charAt(end+1));
                end++;
            }
            ans = Math.max(ans,end-i+1);
        }
        return ans;
    }
}

*/
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        HashMap<Character,Integer> map = new HashMap();
        int left = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else{
                //这里的
                left = Math.max(left,map.get(s.charAt(i))+1);
                map.put(s.charAt(i),i);
            }
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
