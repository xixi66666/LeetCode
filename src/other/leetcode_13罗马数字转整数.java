package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangChenxi
 */
public class leetcode_13罗马数字转整数 {
}
/*
核心思路：
1.例如"MCMXCIV"这样的罗马字母，它按理说应该是字母表示的数字是从大到小排列的
2.如果出现一个字母表示的数字小于它后面表示的数字，那么这个字母表示的其实是它的负数（妙不妙）
3.遍历一遍数组，加上最后一个字母表示的数字就行了
 */
class Solution6 {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum = 0;
        for(int i = 0;i<s.length()-1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else{
                sum += map.get(s.charAt(i));
            }
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;
    }
}