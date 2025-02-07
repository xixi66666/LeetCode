package 基础数据结构.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 6
 * @author: 杨晨曦
 * @create: 2022-11-28 11:12
 **/
public class leetcode_6z字形变换 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String leetcode = solution6.convert("leetcode", 3);
        System.out.println(leetcode);
    }
/*
思路一：
行数为4的时候 1 2 3 4 3 2 1 2 3 4 3 2 1
1 2 3 2 1 2 3 2 1
1 2 3 4 5 4 3 2 1 2 3 4 5
规律： 2n-2为一组

思路2：
因为是n字形的，如果有四行的话，那么一个字符串最后的顺序就应该是
1 2 3 4 3 2 1
所以有几行就弄几个String数组按顺序放进去最后拼接就行了
难点就是里面这个n形状的逻辑，用一个flag就行了，
到0或者s.length的时候改变正负，天才，我咋想不到
\
 */
}
class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for(char c : s.toCharArray()){
            list.get(i).append(c);
            if(i == 0 || i == numRows-1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : list){
            res.append(row);
        }
        return res.toString();
    }
}